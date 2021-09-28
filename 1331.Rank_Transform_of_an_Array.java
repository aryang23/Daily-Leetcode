class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // HashSet<Integer>  set = new HashSet<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int num : set) {
            map.put(num, rank++);
        }
        int[] ranks = new int[n];
        for(int i=0;i<n;i++)
        {
            ranks[i] = map.get(arr[i]);
        }
        return ranks;
    }
    
    public int[] arrayRankTransform2(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int num : set) {
            map.put(num, rank++);
        }
        int[] ranks = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ranks[i] = map.get(arr[i]);
        }
        return ranks;
    }
}
