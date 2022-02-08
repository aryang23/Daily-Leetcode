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
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];
        int max = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == '0') {
                    arr[j] = 0;
                } else {
                    arr[j] += 1;
                }
            }
            int area = largestRectangleArea(arr);
            max = Math.max(max, area);
        }
        return max;
    }
}