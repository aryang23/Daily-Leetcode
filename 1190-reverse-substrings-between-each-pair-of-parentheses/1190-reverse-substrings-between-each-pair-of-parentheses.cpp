class Solution {
public:
    string reverseParentheses(string s) {
        
        stack<string> st;
        string r="";
        string ans="";
        for(int i=0;i<s.size();i++)
        {
            
            if(s[i]=='(')
            {
                
                     cout<<"a";
                    st.push(r);
                
                r="";
                
            }
            else if(s[i]==')')
            {
                reverse(r.begin(),r.end());
            //    cout<<st.top()<<endl;
                if(st.size()!=0)
                {
                   
                r=st.top()+r;
                st.pop();
                }
                
                
                
            }
            else
                r=r+s[i];
            
            
            
        }
        
        return r;
    }
};