//BEST QUES

class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        for(int i=0;i<nums2.length;i++)
        {
            map.put(nums2[i], i);
        }
        int[] ans = new int[nums1.length];
        int t = 0;
        for(int x:nums1)
        {
            ans[t++] = map.get(x);
        }
        return ans;
    }
}
