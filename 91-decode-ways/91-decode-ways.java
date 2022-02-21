class Solution {
    public int numDecodings(String s) {
        int count = 0;
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        // int ans = numDecodingsHelper(s);
        // int ans = countEncodings(s);
        int ans = numDecodings(s, 0, dp);
        return ans;
   }
    public int numDecodingsHelper(String str) {
        if(str.length() == 0) {
            return 1;
        }
        if(str.charAt(0) == '0') {
            return 0;
        }
        
        int count = 0;
        String ch1= str.substring(0,1);
        String ros1 = str.substring(1);
        count += numDecodingsHelper(ros1);
        
        if(str.length() >= 2) {
            String ch2 = str.substring(0, 2);
            String ros2 = str.substring(2);
            if(Integer.parseInt(ch2) <= 26) {
                count += numDecodingsHelper(ros2);
            }
        }
        return count;
    }
    
    public static int countEncodings(String str) {
        
        if(str.charAt(0)=='0')
            return 0;
        
        int n = str.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++) {
            char pc = str.charAt(i-2);
            char cc = str.charAt(i-1);
            if(pc=='0') {
                if(cc=='0') {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i-1];
                }
            } else if(cc == '0') {
                if(Integer.parseInt(str.substring(i-2, i)) <= 26) {
                    dp[i] = dp[i-2];
                }
            } else {
                dp[i] = dp[i-1];
                if(Integer.parseInt(str.substring(i-2, i))<=26) {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[n];
    }
    
    public int numDecodings(String s, int idx, int[] dp) {
        if(idx == s.length()) {
            return dp[idx] = 1;
        }
        if(dp[idx] != -1) {
            return dp[idx];
        }
        
        char ch = s.charAt(idx);
        if(ch=='0') {
            return dp[idx] = 0;
        }
        int count = numDecodings(s, idx+1, dp);
        if(idx < s.length() - 1) {
            char ch1 = s.charAt(idx+1);
            int num = (ch-'0')*10 +(ch1-'0');
            if(num <= 26) {
                count += numDecodings(s, idx+2, dp);
            }
        }
        return dp[idx] = count;
    }
}