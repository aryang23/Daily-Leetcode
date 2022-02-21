class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer cand = null;
        
        for(int num : nums) {
            if(count==0) {
                cand = num;
            }
            if(cand == num) {
                count++;
            } else {
                count--;
            }
        }
        return cand;
    }
}