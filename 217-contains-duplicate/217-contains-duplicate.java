class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int val:nums) {
            if(map.containsKey(val))
                return true;
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return false;
        
    }
}