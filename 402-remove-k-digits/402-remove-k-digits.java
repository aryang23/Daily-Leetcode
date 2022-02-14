class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<num.length(); i++) {
            char ch = num.charAt(i);
            
            while(st.size() > 0 && k>0 && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k>0) {
            st.pop();
            k--;
        }
        if(st.size()==0) {
            return "0";
        }
        char[] arr = new char[st.size()];
        int idx = arr.length-1;
        
        while(st.size()>0) {
            arr[idx--] = st.pop();
        }
        
        
        StringBuilder sb = new StringBuilder("");
        int fnz = arr.length-1;
        for(int i=0; i<arr.length; i++) {
            sb.append(arr[i]);
            
            if(fnz==arr.length-1 && arr[i] != '0') {
                fnz = i;
            }
        }
        return sb.toString().substring(fnz);
//         while(st.size()>0) {
//             sb.append(st.pop());
//         }
//         sb.reverse();
//         // Collections.reverse(sb);
//         String ans = sb.toString();
//         int a2 = Integer.parseInt(ans);
//         return (a2+"");
//         int fnz = -1;
//         int idx = 0;
//         while(idx<ans.length() && ans.charAt(idx)=='0') {
//             idx++;
//         }
        
//         fnz = idx;
//         System.out.println(fnz);
//         if(fnz==-1 || fnz>ans.length())
//             return ans;
//         //ans = ans.reverse();
//         return ans.substring(fnz);
    }
}