class KthLargest {

    public KthLargest(int k, int[] nums) {
        _pq = new PriorityQueue<Integer>((a,b)->a-b);
        this.k = k;
        for(int i = 0; i < nums.length; i++)        
            _pq.add(nums[i]);
        while(_pq.size() > k)                       
            _pq.poll();
    }
    
    public int add(int val) {
        _pq.add(val);
        if(_pq.size() > k)  
            _pq.poll();
        return _pq.peek();
    }
    PriorityQueue<Integer> _pq;
    int k;
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */