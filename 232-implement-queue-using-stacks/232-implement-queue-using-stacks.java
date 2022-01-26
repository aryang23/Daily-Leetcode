class MyQueue {
    LinkedList<Integer> st;
    LinkedList<Integer> temp;
    public MyQueue() {
        st = new LinkedList<>();
        temp = new LinkedList<>();
    }
    
    public void push(int x) {
        st.addFirst(x);
    }
    
    public void swapData(LinkedList<Integer> st1, LinkedList<Integer> st2) {
        while(st1.size() != 0) {
            st2.addFirst(st1.removeFirst());
        }
    }
    
    public int pop() {
        swapData(st, temp);
        int rv = temp.removeFirst();
        swapData(temp, st);
        return rv;
    }
    
    public int peek() {
        swapData(st, temp);
        int rv = temp.getFirst();
        swapData(temp, st);
        return rv;
    }
    
    public boolean empty() {
        return this.st.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */