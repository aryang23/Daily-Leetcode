class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++)
        {
            Integer val = map.get(nums1[i]);
            if(val==null)
                map.put(nums1[i], 1);
            else
            map.put(nums1[i], val+1);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums2.length;i++)
        {
            int num = nums2[i];
            if(map.containsKey(num) && map.get(num)>0)
            {
                res.add(num);
                int val = map.get(num);
                val--;
                map.put(num, val);
            }
        }
        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++)
        {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
