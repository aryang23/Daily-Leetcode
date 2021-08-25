class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        
        int val1 = nums[0];
        int count1 = 1;
        
        int val2 = nums[0];
        int count2 = 0;
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=1;i<n;i++)
        {
            if(nums[i]==val1)
            {
                count1++;
            }
            else if(nums[i]==val2)
            {
                count2++;
            }
            else
            {
                if(count1==0)
                {
                    val1 = nums[i];
                    count1++;
                }
                else if(count2==0)
                {
                    val2 = nums[i];
                    count2++;
                }
                else
                {
                    count1--;
                    count2--;
                }
            }
        }
        count1=0;
        count2 = 0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==val1)
                count1++;
            else if(nums[i]==val2)
                count2++;
        }
        if(count1>n/3)
            ans.add(val1);
        if(count2>n/3)
            ans.add(val2);
        
        return ans;
    }
}
