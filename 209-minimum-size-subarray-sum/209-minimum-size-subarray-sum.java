//? Solution Notes:
//! KEY - 'Minimum Size' + 'Subarray/Substring' + 'Target/Sum' = SLIDING WINDOW
//* [Faster than 99.96% of Java online submissions]

//* 1) 2Ptrs i & j, Both Start at 0, j moving left to right.
//* 2) Add j's value to sum. j increments with loop.
//* 3) while(sum>=target) -> remove i's value. increment i. update min length.
    //* --min length is initially high constant.
    //* --if i == j, sum is value at i or j.
    //* --if min length is never updated, return 0. else return min length.

//? Complexity:
//* TC -> O(N)
    //* Iterate through the Loop Once.
//* SC -> O(1)
    //* Use only i,j,sum, and minLength regardless of size of nums[]
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, sum = 0, minLength = Integer.MAX_VALUE;
        for(; j < nums.length; j++){
            sum+=nums[j];
            if(i == j) sum = nums[j];
            while(sum >= target){
                minLength = Math.min(minLength, j - i + 1);
                sum -= nums[i++];
            }
        }
        if(minLength == Integer.MAX_VALUE) return 0;
        return minLength;
    }
}
