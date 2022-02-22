class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Character[] words = s.toCharArray();
        
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Boolean> used = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if(map.containsKey(ch1) == false) {
                if(used.containsKey(ch2) == true) {
                    return false;
                } else {
                    map.put(ch1, ch2);
                    used.put(ch2, true);
                }
            } else {
                Character mw = map.get(ch1);
                if(mw != ch2)
                    return false;
            }
        }
        return true;
    }
}