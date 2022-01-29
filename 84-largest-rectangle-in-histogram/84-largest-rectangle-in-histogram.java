class Solution {
    public int largestRectangleArea(int[] a) {
        int n = a.length;
        int[] nsl = nsl(a);
        int[] nsr = nsr(a);
        
        int ans = 0;
        for(int i=0; i<n; i++) {
            int width = nsr[i]-nsl[i]-1;
            ans = Math.max(ans, a[i]*width);
        }
        return ans;
    }
    
    public static int[] nsl(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        
        ans[0] = -1;
        st.push(0);
        
        for(int i=0; i<n; i++) {
            while(st.size()>0 && arr[st.peek()] >= arr[i])
                st.pop();
            
            if(st.size() == 0)
                ans[i] = -1;
            else
                ans[i] = st.peek();
            
            st.push(i);
        }
        
        return ans;
    }
    
    public static int[] nsr(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        ans[n-1] = n;
        for(int i=n-2; i>=0; i--) {
            while(st.size()>0 && arr[st.peek()] >= arr[i])
                st.pop();
            
            if(st.size() == 0)
                ans[i] = arr.length;
            else
                ans[i] = st.peek();
            
            st.push(i);
        }
        return ans;
    }
}