class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        
        //( is denoted by -1
        
        for(char ch:s.toCharArray()) {
            if(ch=='(') {
                st.push(-1);
            } else {
                if(st.peek()==-1) {
                    st.pop();
                    st.push(1);
                } else {
                    int sc = 0;
                    while(st.peek() != -1 ) {
                        sc += st.pop();
                    }
                    st.pop();
                    st.push(sc*2);
                }
            }
        }
        int ans = 0;
        while(st.size() > 0) {
            ans += st.pop();
        }
        return ans;
    }
}