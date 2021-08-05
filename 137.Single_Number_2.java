class Solution {
    public int singleNumber2(int[] nums) {
        
        int[] bitsArr = new int[32];
        for(int i=0;i<nums.length;i++)
        {
            int temp = nums[i];
            int arrPtr = 31;
            while(temp>0)
            {
                int sb = temp&1;
                temp=temp>>>1;
                bitsArr[arrPtr]+=sb;
                arrPtr--;
            }
        }
        
        for(int i=0;i<32;i++)
        {
            // System.out.println(bitsArr[i]);
            bitsArr[i]=bitsArr[i]%3;
        }
        int pow = 1;
        int ans = 0;
        int arrPtr = 31;
        while(arrPtr>0)
        {
            ans+=pow*bitsArr[arrPtr];
            arrPtr--;
            pow*=2;
        }
        return ans;
        // return 3;
    }
    
//     public int singleNumber(int[] nums)
//     {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i=0;i<nums.length;i++)
//         {
//             if(map.containsKey(nums[i]))
//             {
//                 int val = map.get(nums[i]);
//                 val++;
//                 map.put(nums[i],val);
//             }
//             else
//             {
//                 map.put(nums[i],1);
//             }
//         }
        
//         for (Integer e : map.keySet())
//         {
//             if(map.get(e)==1)
//             {
//                 return e;
//             }
//         }
//         return -1;
//     }
    
    public int singleNumber(int[] nums)
    {
        int k = 3;
        int ans = 0;
        for(int i=0;i<32;i++)
        {
            int mask = (1<<i);
            int count = 0;
            for(int el:nums)
            {
                if((el&mask)!=0)
                    count++;
            }
            
            ans|=(count%k)!=0?mask:0;
        }
        return ans;
    }
    
    
}
