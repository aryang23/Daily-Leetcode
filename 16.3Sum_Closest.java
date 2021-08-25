class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        int n = nums.length;
        int closestSum = nums[0]+nums[1]+nums[n-1];
        for(int i=0;i<n-2;i++)
        {
            if(i==0 || (i>0 && nums[i]!=nums[i-1]))
            {
                int lo = i+1, hi = n-1;
                
                while(lo<hi)
                {
                    int cSum = nums[i]+nums[lo]+nums[hi];
                    if(Math.abs(cSum-target)<Math.abs(closestSum-target))
                    closestSum = cSum;
                    
                    if(cSum<target)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return closestSum;
    }
}
