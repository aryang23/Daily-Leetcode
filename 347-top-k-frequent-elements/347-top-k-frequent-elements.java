class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) 
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        
        for(Map.Entry<Integer, Integer> e : freq.entrySet()) 
            pq.offer(new int[] {e.getKey(), e.getValue()});
        
        int[] result = new int[k];
        
        while(k-- > 0) {
            result[k] = (pq.poll())[0];
        }
        
        return result;
    }
}
