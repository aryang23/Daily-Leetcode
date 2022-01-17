class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        if(pattern.length() != words.length)
            return false;
        
        HashMap<Character, String> map = new HashMap<>(); 
        HashMap<String, Boolean> used = new HashMap<>();
        for(int i=0;i<pattern.length();i++) {
            char ch = pattern.charAt(i);
            
            if(map.containsKey(ch) == false) {
                if(used.containsKey(words[i]) == true) {
                    return false;
                } else {
                    map.put(ch, words[i]);
                    used.put(words[i], true);
                }
            } else {
                String mwith = map.get(ch);
                if(mwith.equals(words[i]) == false) {
                    return false;
                }
            }
        }
        return true;
    }
}