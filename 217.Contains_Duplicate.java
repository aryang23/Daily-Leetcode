class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int num = nums[i];
            if(map.containsKey(num))
                return true;
            map.put(num, 1);
        }
        return false;
    }
}
