class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val:nums) {
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        int res = 0;
        for(Integer key:map.keySet()) {
            Integer val = map.get(key);
            if(k>0 && map.get(key + k) != null) {
                res++;
            }
            else if(k==0 && val!=null && val>1) {
                res++;
            }
        }
        return res;
    }
}