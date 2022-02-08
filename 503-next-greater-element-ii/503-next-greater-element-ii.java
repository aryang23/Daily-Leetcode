class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
       

       Stack<Integer> st = new Stack<>();
       
       st.push(arr[n-1]);

       for(int i=n-2; i>=0; i--) {
         while(st.size() > 0 && st.peek() <= arr[i]) {
           st.pop();
         }
           
         st.push(arr[i]);
       }
        st.push(arr[n-1]);
        int[] nge = new int[n];
    
       for(int i=n-1; i>=0; i--) {
         while(st.size() > 0 && st.peek() <= arr[i]) {
           st.pop();
         }

         if(st.size()==0) {
           nge[i] = -1;
         } else {
           nge[i] = st.peek();
         }
         st.push(arr[i]);
       }
       return nge;
    }
}