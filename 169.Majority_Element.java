class Solution {
    public int majorityElement(int[] nums) {
        int el = 0, c = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(c==0)
                el = nums[i];
            if(nums[i]==el)
                c++;
            else
                c--;
        }
        return el;
    }
}
