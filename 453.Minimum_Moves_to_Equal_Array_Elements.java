class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int ele:nums)
        {
            min = Math.min(min, ele);
            sum+=ele;
        }
        int x = sum-min*nums.length;
        return x;
    }
}

//Think of it in opposite direction
//Like 1,2,3 n we want to reach at the minimum, like we want to reach at 1
//So find minimum and take all elements to min
//ans=num1-min+num2-min+num3-min...
//ans = num1+num2+num3...-min*n
// ans=sum-min*n //these will be the moves
