class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
    int a = 0;
    int b = 0;
    int c = 0;
    int indx = nums.length - 3;
    
    while(indx >= 0) {
        a = nums[indx];
        b = nums[indx + 1];
        c = nums[indx + 2];
        
        if(a + b > c) {
            return a + b + c;
        }
        indx--;
    }
    return 0;
    }
}