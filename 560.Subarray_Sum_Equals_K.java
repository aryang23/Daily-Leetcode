class Solution {
    public int subarraySum3(int[] nums, int k)
    {
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++)
        {
            int sum = 0;
            for(int j=i;j<n;j++)
            {
                sum+=nums[j];
                if(sum==k)
                    count++;
            }
        }
        return count;
    }
    
    public int subarraySum(int[] nums, int k)
    {
        int n = nums.length;
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            if(map.containsKey(sum-k))
                count+=map.get(sum-k);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
