class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0)
            return false;
        
        Stack<Character> st = new Stack<Character>();
        boolean flag = true;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                st.push(s.charAt(i));
            else
            {
                if(st.empty())
                {
                    flag = false;
                    break;
                }
                else if(s.charAt(i) == ')')
                {
                    if(st.peek()=='(')
                        st.pop();
                    else
                    {
                        flag = false;
                        break;
                    }
                }
                else if(s.charAt(i) == ']')
                {
                    if(st.peek() == '[')
                        st.pop();
                    else
                    {
                        flag = false;
                        break;
                    }
                }
                else if(s.charAt(i) == '}')
                {
                    if(st.peek() == '{')
                        st.pop();
                    else
                    {
                        flag = false;
                        break;
                    }
                }
            }
        }
        if(flag == false)
            return false;
        if(st.empty())
            return true;
        return false;
    }
    
    public boolean isValiid(String s) {
        if(s.length()%2 != 0)
            return false;
        
        Stack<Character> st = new Stack<Character>();
        boolean flag = true;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch=='(' || ch=='{' || ch=='{') {
                st.push(ch);
            } else {
                if(st.empty()) {
                    flag = false;
                    break;
                } else if(ch == ')') {
                    if(st.peek() == '(') {
                        st.pop();
                    } else {
                        flag = false;
                        break;
                    }
                } else if(ch == '}') {
                    if(st.peek() == '{') {
                        st.pop();
                    } else {
                        flag = false;
                        break;
                    }
                } else if(ch == ']') {
                    if(st.peek() == '[') {
                        st.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
        }
        if(flag == false)
            return false;
        if(st.empty())
            return true;
        return false;
    }
}