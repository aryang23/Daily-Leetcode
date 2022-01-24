class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char ch:magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(char ch:ransomNote.toCharArray()) {
            if(map.containsKey(ch) == true) {
                int val = map.get(ch);
                if(val > 0){
                    val--;
                    map.put(ch, val);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}