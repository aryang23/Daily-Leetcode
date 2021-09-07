class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char ch='a';
        int n = keysPressed.length();
        int max = 0;
        for(int i=0;i<n;i++)
        {
            int currMax = (i>0)?releaseTimes[i]-releaseTimes[i-1]:releaseTimes[0];
            // System.out.println(currMax);
            char currChar = keysPressed.charAt(i);
            
            if(currMax >= max)
            {
                if(currMax==max)
                {
                    if(currChar > ch)
                        ch = currChar;
                    continue;
                }
                max = currMax;
                ch = currChar;
            }
        }
        return ch;
    }
}
