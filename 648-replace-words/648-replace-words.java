class Solution {
    private class Node {
        Node[] children;
        String s;
        Node() {
            this.children = new Node[26];
            this.s = null;
        }
    }
    
    private void insert(String word, Node root) {
        Node temp = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(temp.children[ch-'a'] == null)
                temp.children[ch-'a'] = new Node();
            temp = temp.children[ch-'a'];
        }
        temp.s = word;
    }
    private String search(String word, Node root) {
        Node temp = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(temp.children[ch-'a']==null)
                return null;
            temp = temp.children[ch-'a'];
            if(temp.s != null)
                return temp.s;
        }
        return null;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        for(String word : dictionary) {
            insert(word, root);
        }
        
        String[] senWords = sentence.split(" ");
        for(int i=0; i<senWords.length; i++) {
            String matched = search(senWords[i], root);
            if(matched != null) {
                senWords[i] = matched;
            }
        }
        
        String ans = senWords[0];
        for(int i=1; i<senWords.length; i++) {
            ans += " " + senWords[i];
        }
        return ans;
    }
};