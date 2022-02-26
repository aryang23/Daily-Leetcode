class Solution {
    private int[] nums;
    private Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        int[] copy = nums.clone();
        for(int i=nums.length-1; i>=0; i--) {
            int j = random.nextInt(i+1);
            int t = copy[i];
            copy[i] = copy[j];
            copy[j] = t;
        }
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */