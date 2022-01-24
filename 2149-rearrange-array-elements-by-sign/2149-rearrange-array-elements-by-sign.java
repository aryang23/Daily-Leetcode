class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] < 0)
                neg.add(nums[i]);
            else
                pos.add(nums[i]);
        }
        
        int[] res = new int[n];
        int pptr = 0, nptr = 0;
        for(int i=0; i<n; i+=2) {
            res[i] = pos.get(pptr++);
            res[i+1] = neg.get(nptr++);
        }
        return res;
    }
}