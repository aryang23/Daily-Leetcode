class Solution {
    public static int count3 = 0;
    public int numDecodings(String s) {
        int count = 0;
        // int ans = numDecodingsHelper(s);
        // int ans = numDecodingsHelper2(s, 0);
        // int count2 = countEncodings(s);
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        // return numDecodings(s, 0, dp);
        // return numDecodingsTab(s, 0, dp);
        return numDecodingsOpt(s);
    }
    
    //BEST WAY Memo
    public int numDecodings(String s,int idx, int[] dp)
    {
        if(idx==s.length())
            return dp[idx] = 1;
        
        if(dp[idx]!=-1)
            return dp[idx];
        
        char ch = s.charAt(idx);
        if(ch=='0')
            return dp[idx] = 0;
        
        int count = numDecodings(s, idx+1, dp);
        
        if(idx < s.length()-1)
        {
            char ch1 = s.charAt(idx+1);
            int num = (ch-'0')*10+(ch1-'0');
            if(num<=26)
                count+=numDecodings(s, idx+2, dp);
        }
        return dp[idx] = count;
    }
    
    //BEST WAY Tab
    public int numDecodingsTab(String s,int IDX, int[] dp)
    {
        for(int idx=s.length();idx>=0;idx--)
        {
            if(idx==s.length())
            {
                dp[idx] = 1;
                continue;
            }

            char ch = s.charAt(idx);
            if(ch=='0')
            {
                dp[idx] = 0;
                continue;
            }

            int count = dp[idx+1];//numDecodings(s, idx+1, dp);

            if(idx < s.length()-1)
            {
                char ch1 = s.charAt(idx+1);
                int num = (ch-'0')*10+(ch1-'0');
                if(num<=26)
                    count += dp[idx+2];//numDecodings(s, idx+2, dp);
            }
            dp[idx] = count;
        }
        return dp[IDX];
    }
    
    //BEST WAY OPT
    public int numDecodingsOpt(String s)
    {
        int a = 1, b = 0;
        for(int idx=s.length()-1;idx>=0;idx--)
        {
            char ch = s.charAt(idx);
            int sum = 0;
            if(ch!='0')
            {
                sum += a;
                
                if(idx < s.length()-1)
                {
                    char ch1 = s.charAt(idx+1);
                    int num = (ch-'0')*10+(ch1-'0');
                    if(num<=26)
                        sum += b; //numDecodings(s, idx+2, dp);
                }
            }
            b = a;
            a = sum;
        }
        return a;
    }
    
    
    //Not Working bcz of TLE
    public int numDecodingsHelper(String str)
    {
        if(str.length()==0)
        {
            return 1;
        }
        
        if(str.charAt(0)=='0')
            return 0;
        int count = 0;
        String ch0 = str.substring(0,1);
        String ros1 = str.substring(1);
        count += numDecodingsHelper(ros1);
        
        if(str.length()>=2)
        {
            String ch1 = str.substring(0, 2);
            String ros2 = str.substring(2);
            if(Integer.parseInt(ch1)<=26)
                count+=numDecodingsHelper(ros2);
        }
        
        return count;
    }
    
    //Working fine
    public static int countEncodings(String str)
    {
        if(str.charAt(0)=='0')
            return 0;
        
        int n = str.length();
        int[] dp = new int[str.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++)
        {
            char pc = str.charAt(i-2);
            char cc = str.charAt(i-1);
            if(pc=='0')
            {
                if(cc=='0')
                    dp[i] = 0;
                else
                    dp[i] = dp[i-1];
            }
            else if(cc=='0')
            {
                if(Integer.parseInt(str.substring(i-2, i))<=26)
                    dp[i] = dp[i-2];
            }
            else
            {
                dp[i] = dp[i-1];
                if(Integer.parseInt(str.substring(i-2, i))<=26)
                    dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
    
}
