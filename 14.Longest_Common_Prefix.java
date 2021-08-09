class Solution {
    public String longestCommonPrefix(String[] strs) {
        String minStr = "";
        int minStrLen = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++)
        {
            if(strs[i].length() < minStrLen)
            {
                minStr = strs[i];
                minStrLen = strs[i].length();
            }
        }
        
        String ansStr = "";
        for(int i=minStrLen-1;i>=0;i--)
        {
            String smallStr = minStr.substring(0, i+1);
            boolean smallAns = true;
            for(int j=0;j<strs.length;j++)
            {
                if(strs[j]==minStr)
                    continue;
                else
                {
                    if(!compare(strs[j], smallStr))
                    {
                        smallAns = false;
                        break;
                    }
                }
            }
            if(smallAns == true)
            {
                ansStr = smallStr;
                break;
            }
        }
        return ansStr;
        
    }
    
    public boolean compare(String mainStr, String smallStr)
    {
        for(int i=0;i<smallStr.length();i++)
        {
            if(mainStr.charAt(i)!=smallStr.charAt(i))
                return false;
        }
        return true;
    }
}
