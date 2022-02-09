class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<3)
            return res;
        int i = 0, j = nums.length - 1;
        int prev = Integer.MIN_VALUE, prevI = Integer.MIN_VALUE;
        HashSet<List> set = new HashSet(); 
        
        while(i<=j) {
            int k = i+1;
            j = nums.length - 1;
            
            if(prevI == i) {
                i++;
                continue;
            }
            
            while(k<j) {
                if(nums[k] == prev) {
                    k++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    List<Integer> ba = new ArrayList<>();
                    
                    ba.add(nums[i]);
                    ba.add(nums[j]);
                    ba.add(nums[k]);
                    
                    // res.add(ba);
                    set.add(ba);
                    
                    k++;
                    j--;
                } else if(sum>0){
                    j--;
                }else{
                    k++;
                }
            }
            i++;
        }
        for (List value : set)
        {
            res.add(value);
        }
        return res;
    }
}