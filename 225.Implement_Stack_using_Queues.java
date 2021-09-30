class MyStack {
    LinkedList<Integer> st = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    public MyStack() {
        que = new Queue<>();
    }
    
    public void push(int x) {
        st.addFirst(x);
    }
    public void swapData(LinkedList<Integer> st1, LinkedList<Integer> st2)
    {
        while(st1.size() != 0)
        {
            st2.addFirst(st1.removeFirst());
        }
    }
    public int pop() {
        swapData(st, temp);
        int rv = temp.removeFirst();
        swapData(temp, st);
    }
    
    public int top() {
        swapData(st, temp);
    }
    
    public boolean empty() {
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
