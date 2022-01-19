class WordDictionary {
    private class Node {
        Node[] children;
        boolean isEnd;
        
        Node() {
            this.children = new Node[26];
            this.isEnd = false;
        }
    }
    
    private Node root = null;
    
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node temp = root;
        
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(temp.children[ch - 'a'] == null) {
                Node nn = new Node();
                temp.children[ch - 'a'] = nn;
            }
            temp = temp.children[ch - 'a'];
        }
        temp.isEnd = true;
    }
    
    
    private boolean find(Node node,  String word, int indx) {
        if(indx == word.length()) {
            return node.isEnd;
        }
        
         char ch = word.charAt(indx);
        
        if(ch == '.') {
            for(int i=0; i<26; i++) {
                Node child = node.children[i];
                if(child != null && find(child, word, indx + 1) == true) {
                    return true;
                }
            }
        } else if(node.children[ch - 'a'] != null) {
            return find(node.children[ch-'a'], word, indx + 1);
        }
        
        return false;
    }
    public boolean search(String word) {
        return find(root, word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */