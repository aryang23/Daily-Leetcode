class Solution {
    public List<Integer> findLonely(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        
        for(int val : nums) {
            if(map.get(val) == 1) {
                if(map.containsKey(val-1)==false && map.containsKey(val+1)==false)
                    ans.add(val);
            }
        }
        return ans;
        
    }
}