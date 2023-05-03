class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> sa = new ArrayList<>();
        List<List<Integer>> ma = new ArrayList<>();

        HashSet<Integer> ca = new HashSet<>();

        for(int v:nums2) {
            set.add(v);
        }

        for(int v:nums1) {
            if(!set.contains(v)) {
                ca.add(v);
            }
        }
        for(int v:ca) {
            sa.add(v);
        }
        ma.add(sa);

        set = new HashSet<>();
        sa = new ArrayList<>();
        ca = new HashSet<>();
        System.out.println(set.size());

        for(int v:nums1) {
            set.add(v);
        }
        System.out.println(set.size());


        for(int v:nums2) {
            if(!set.contains(v)) {
                ca.add(v);
            }
        }
        for(int v:ca) {
            sa.add(v);
        }
        ma.add(sa);
        
        

        return ma;
    }
}
