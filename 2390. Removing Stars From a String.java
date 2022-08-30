class Solution {
    public String removeStars(String s) {
        char[] chArr = s.toCharArray();
        int n = s.length();
        int i = 0;
        int cnt = 0;
        Stack<Character> st = new Stack<>();
        for(char ch : chArr) {
            if(ch=='*') {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.empty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
