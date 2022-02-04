class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        if(n==0)
            return 0;
        
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                nums[i] = -1;
            }
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int psum = 0;
        int maxLen = 0;
        for(int i=0; i<n; i++) {
            psum += nums[i];
            if(map.containsKey(psum)) {
                if(maxLen < i-map.get(psum)) {
                    maxLen = i - map.get(psum);
                }
            }
            map.putIfAbsent(psum, i);
        }
        return maxLen;
    }
}
//0, 1, 0, 
//1, 0, 1