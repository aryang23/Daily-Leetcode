class Solution {
    public static class Pair implements Comparable<Pair> {
        int val;
        int dist;
        
        public Pair(int val, int dist)
        {
            this.val = val;
            this.dist = dist;
        }
        
        public int compareTo(Pair o)
        {
            if(this.dist == o.dist)
                return this.val - o.val;
            else
                return this.dist - o.dist;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Approach 1
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<arr.length;i++)
        {
            if(i<k)
            {
                pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
            }
            else
            {
                if(pq.peek().dist > Math.abs(arr[i] - x))
                {
                    pq.remove();
                    pq.add(new Pair(arr[i], Math.abs(x-arr[i])));
                }
            }
        }
        
        while(pq.size() > 0)
        {
            res.add(pq.remove().val);
        }
        
        Collections.sort(res);
        return res;
    }
}
