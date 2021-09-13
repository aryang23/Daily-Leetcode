class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        int sum=0;
        char sign='+';
        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch))
            {
                int val = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i)))
                {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                if(sign=='+')
                {
                    st.push(val);
                }
                else if(sign=='-')
                {
                    st.push(-val);
                }
                else if(sign=='*')
                {
                    int a = st.pop();
                    int ans = a*val;
                    st.push(ans);
                }
                else if(sign=='/')
                {
                    int a = st.pop();
                    int ans = a/val;
                    st.push(ans);
                }
            }
            else if(ch!=' ')
            {
                sign = ch;
            }
        }
        sum = 0;
        while(st.size()>0)
            sum+=st.pop();
        
        return sum;
    }
}
