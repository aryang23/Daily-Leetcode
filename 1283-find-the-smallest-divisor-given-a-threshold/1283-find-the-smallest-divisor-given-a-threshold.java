class Solution {
    
    private boolean isPossible(int[] nums, int h, int speed) {
        int left = 0;
        for(int i=0;i<nums.length;i++) {
            left += (int)Math.ceil(nums[i] * 1.0 / speed);
        }
        return (left<=h);
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MAX_VALUE;
        
        int lo = 1;
        int hi = max;
        int k = Integer.MAX_VALUE;
        
        while(lo <= hi) {
            int div = lo + (hi - lo) / 2;
            if(isPossible(nums, threshold, div) == true){
                k = div;
                hi = div - 1;
            } else {
                lo = div + 1;
            }
        }
        
        return k;
    }
}