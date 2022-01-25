class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(map.get(ch) == 1)
                return i;
        }
        
        return -1;
    }
}