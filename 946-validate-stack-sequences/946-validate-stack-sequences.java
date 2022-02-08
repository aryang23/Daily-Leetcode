class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int i=0;
        int j=0;
        int c=0;
        
        Stack<Integer> st= new Stack<>();
        
        while(j<n) {
            if(st.size()>0 && popped[j] == st.peek()) {
                st.pop();
                j++;
                c++;
            } else if(i<n) {
                st.push(pushed[i]);
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}