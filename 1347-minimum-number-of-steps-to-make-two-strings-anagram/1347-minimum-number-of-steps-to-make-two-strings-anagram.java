class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        
        for(char ch:s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(char ch:t.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        
        int ans = 0;
        for(char ch:map.keySet()) {
            Integer sVal = map.get(ch);
            Integer tVal = map2.get(ch);
            sVal = sVal==null?0:sVal;
            tVal = tVal==null?0:tVal;
            if(tVal < sVal) {
                ans += (sVal-tVal);
            }
        }
        
        return ans;
    }
}