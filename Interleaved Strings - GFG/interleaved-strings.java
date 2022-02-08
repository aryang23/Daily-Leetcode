// { Driver Code Starts
//initial code
import java.util.*;
import java.lang.*;
class InterLeaveString
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String a =sc.next();
            String b = sc.next();
            String c = sc.next();
            Solution g=new Solution();
        
            System.out.println(g.isInterLeave(a,b,c)==true?1:0);
            t--;
        }
    }
}

// } Driver Code Ends


/*you are required to complete this method */
class Solution {
	public boolean isInterLeave(String s1,String s2,String s3)
	{
            //Your code here
        int n = s1.length();
        int m = s2.length();
        if(n+m!=s3.length())
            return false;
        boolean[][] dp = new boolean[n+1][m+1];
        // dp[0][0] = 1;
        
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if(i==0 && j==0) {
                    dp[i][j] = true;
                } else if(i==0) {
                    dp[i][j] = s2.charAt(j-1)==s3.charAt(i+j-1)?dp[i][j-1]:false;
                } else if(j==0) {
                    dp[i][j] = s1.charAt(i-1)==s3.charAt(i+j-1)?dp[i-1][j]:false;
                } else {
                    char cins1 = s1.charAt(i-1);
                    char cins2 = s2.charAt(j-1);
                    char cins3 = s3.charAt(i+j-1);
                    
                    if(cins1==cins3 && cins2 == cins3) {
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    } else if(cins1==cins3) {
                        dp[i][j] = dp[i-1][j];
                    } else if(cins2 == cins3) {
                        dp[i][j] = dp[i][j-1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[n][m];
	}
}

