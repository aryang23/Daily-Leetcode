class Solution {
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<3)
            return res;
        int i = 0, j = nums.length - 1;
        int prev = Integer.MIN_VALUE, prevI = Integer.MIN_VALUE;
        HashSet<List> set = new HashSet(); 
        
        while(i<=j)
        {
            int k = i+1;
            j = nums.length-1;
            
            if(prevI==i)
            {
                i++;
                continue;
            }
            
            while(k<j)
            {
                if(nums[k]==prev)
                {
                    k++;
                    continue;
                }
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)
                {
                    List<Integer> ba = new ArrayList<>();
                    
                    ba.add(nums[i]);
                    ba.add(nums[j]);
                    ba.add(nums[k]);
                    
                    // res.add(ba);
                    set.add(ba);
                    
                    k++;
                    j--;
                }
                else if(sum>0)
                {
                    j--;
                }
                else
                {
                    k++;
                }
            }
            i++;
            // prevI = i;
        }
        for (List value : set)
        {
            res.add(value);
        }
 
        return res;
    }
    
    public List<List<Integer>> threeSum(int[] num)
    {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        
        for(int i=0;i<num.length-2;i++)
        {
            if(i==0 || (i>0 && num[i]!=num[i-1]))
            {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                
                while(lo<hi)
                {
                    if(num[lo]+num[hi]==sum)
                    {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        
                        while(lo<hi && num[lo]==num[lo+1])
                            lo++;
                        while(lo<hi && num[hi] == num[hi-1])
                            hi--;
                        
                        lo++;
                        hi--;
                    }
                    else if(num[lo]+num[hi]<sum)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return res;
    }
    
    
}
