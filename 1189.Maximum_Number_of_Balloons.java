class Solution {
    public int maxNumberOfBalloons(String text) {
        
        String pattern = "balloon";
        return maxNumberOfBalloons(text, pattern);
    }
    
    
    public int maxNumberOfBalloons(String text, String pattern)
    {
        int n = text.length(), m = pattern.length();
        int freqInText[] = new int[26];
        int freqInPattern[] = new int[26];
        
        for(int i=0;i<n;i++)
        {
            freqInText[text.charAt(i)-'a']++;
        }
        
        for (int i = 0; i < m; i++) {
            freqInPattern[pattern.charAt(i) - 'a']++;
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            // Do not divide by zero.
            if (freqInPattern[i] > 0) {
                ans = Math.min(ans, freqInText[i] / freqInPattern[i]);
            }
        }
        
        return ans;
    }
}
