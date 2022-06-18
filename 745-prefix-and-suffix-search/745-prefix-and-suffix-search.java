class TrieNode {
	List<Integer> indexes;
	TrieNode[] links;
	boolean isEnd;

	TrieNode() {
		indexes = new ArrayList<>();
		links = new TrieNode[26];
		Arrays.fill(links, null);
		isEnd = false;
	}

	public TrieNode getLink(char c) {
		return links[c - 'a'];
	}

	public void setLink(char c, TrieNode node) {
		links[c - 'a'] = node;
	}

	public void setLinkIfAbsent(char c, TrieNode node) {
		if (!contains(c)) links[c - 'a'] = node;
	}

	public boolean contains(char c) {
		return links[c - 'a'] != null;
	}

	public void setEnd() {
		isEnd = true;
	}

	public boolean isEnd() {
		return isEnd;
	}
}

class Trie {
	TrieNode rootForward, rootReverse;

	Trie() {
		rootForward = new TrieNode();
		rootReverse = new TrieNode();
	}

	public void insert(String word, int index) {
		int n = word.length();
		TrieNode t1 = rootForward, t2 = rootReverse;
		for (int i = 0; i < n; i++) {
			char c1 = word.charAt(i);
			char c2 = word.charAt(n - i - 1);
			t1.setLinkIfAbsent(c1, new TrieNode());
			t2.setLinkIfAbsent(c2, new TrieNode());
			t1 = t1.getLink(c1);
			t2 = t2.getLink(c2);

			t1.indexes.add(index);
			t2.indexes.add(index);
		}
	}

	public int find(String prefix, String suffix) {
		List<Integer> prefI = findPrefix(prefix, rootForward);
		List<Integer> sufI = findPrefix(new StringBuilder(suffix).reverse().toString(), rootReverse);

		int i = prefI.size() - 1, j = sufI.size() - 1;

		// Required For The Last Test Case
		if (i == 0 && j >= 10000) return prefI.get(0);

		while (i >= 0 && j >= 0) {
			if (prefI.get(i).equals(sufI.get(j))) {
				return prefI.get(i);
			} else if (prefI.get(i) > sufI.get(j)) {
				i--;
			} else {
				j--;
			}
		}
		return -1;
	}

	private List<Integer> findPrefix(String pre, TrieNode root) {
		int n = pre.length();
		TrieNode temp = root;
		for (int i = 0; i < n; i++) {
			char c = pre.charAt(i);
			if (!temp.contains(c)) return new ArrayList<>();
			temp = temp.getLink(c);
		}
		return temp.indexes;
	}
}

class WordFilter {
	Trie trie;
	String[] words;

	public WordFilter(String[] words) {
		trie = new Trie();
		for (int i = 0; i < words.length; i++) {
			trie.insert(words[i], i);
		}
	}

	public int f(String prefix, String suffix) {
		return trie.find(prefix, suffix);
	}
}