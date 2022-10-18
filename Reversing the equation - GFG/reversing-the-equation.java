//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.reverseEqn(s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseEqn(String S)

    {

        // your code here

        Stack<String> st=new Stack<>();

        int s=0;

        int e=0;

        for(int i=0; i<S.length(); i++)

        {

            if(S.charAt(i)=='+' || S.charAt(i)=='-' ||S.charAt(i)=='*' ||S.charAt(i)=='/')

            {

                st.push(S.substring(s,e));

                st.push(S.charAt(i)+"");

                s=i+1;

            }

            e++;

        }

        st.push(S.substring(s,e));

        StringBuilder ss=new StringBuilder();

        while(!st.isEmpty())

        {

            ss.append(st.pop());

        }

        return ss.toString();

 

    }
}