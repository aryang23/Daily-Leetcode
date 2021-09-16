class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> idx = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            Integer lastIndex = idx.put(nums[i], i);
            if(lastIndex!=null && (i-lastIndex)<=k)
                return true;
        }
        return false;
    }
}

//Nice Solution
//Best Learning: - The returning of prev Index and the New Approach :)
