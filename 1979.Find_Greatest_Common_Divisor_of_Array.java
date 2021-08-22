class Solution {
    public int findGCD(int[] nums) {
        int minElem = Integer.MAX_VALUE;
        int maxElem = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            minElem = Math.min(minElem, nums[i]);
            maxElem = Math.max(maxElem, nums[i]);
        }
        return findGCDHelper(minElem, maxElem);
        
    }
    public int findGCDHelper(int a,int b)
    {
        if(b==0)
            return a;
        return findGCDHelper(b, a%b);
    }
}
