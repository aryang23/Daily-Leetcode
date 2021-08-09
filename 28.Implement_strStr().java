class Solution {
    public int strStr2(String haystack, String needle) {
        
        if(!haystack.contains(needle))
            return -1;
        
        // if(haystack.equals(needle))
        //     return 0;
        
        if(needle.length() == 0)
            return 0;
        
        int idx = -1;
        for(int i=0;i<haystack.length();i++)
        {
            if(haystack.charAt(i)==needle.charAt(0))
            {
                int k = i;
                boolean smallAns = true;
                
                for(int j=0;j<needle.length();j++)
                {
                    if(haystack.charAt(k)!=needle.charAt(j))
                    {
                        smallAns = false;
                        break;
                    }
                    k++;
                }
                if(smallAns==true)
                {
                    idx = i;
                    break;
                }
            }
        }
        return idx;
        
    }
    
    public int strStr(String haystack, String needle)
    {
        int idx = haystack.indexOf(needle);
        return idx;
    }
}
