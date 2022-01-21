class Solution {
    static int m = ((int)1e9)+7;
    public int countPairs(int[] deliciousness) {
        int ret = 0;
        
        // Arrays.sort(deliciousness);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<deliciousness.length; i++) {
            int power = 1;
            for(int j=0;j<=21;j++) {
                long diff = power-deliciousness[i];
                if(map.containsKey((int)diff)) {
                    ret += map.get((int)diff);
                    ret %= m;
                }
                power = power * 2;
            }
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        return ret;
    }
}