class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        
        List<String> res = new ArrayList<>();
        
        if(n==0)
            return res;
        
        int a = nums[0];
        
        for(int i=0; i<n; i++) {
             if(i==n-1 || nums[i]+1 != nums[i+1]) {
                 if(nums[i] != a) {
                     res.add(a+"->"+nums[i]);
                 } else {
                     res.add(a+"");
                 }
                 
                 if(i != n-1) {
                     a = nums[i+1];
                 }
             }
        }
        return res;
    }
}