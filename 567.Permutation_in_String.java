class Solution {
    public boolean checkInclusion(String s1, String s2) {
        List<Integer> ans = new ArrayList<>();
        
        int[] hash = new int[26];
        int[] phash = new int[26];
        
        int window = s1.length();
        int len = s2.length();
        
        if(len<window)
            return false;
        
        int left=0, right=0;
        
        while(right<window)
        {
            phash[s1.charAt(right)-'a']+=1;
            hash[s2.charAt(right++)-'a']+=1;
        }
        
        right -= 1;
        while(right < len)
        {
            if(areEqual(hash, phash))
                return true;
            right += 1;
            if(right != len)
                hash[s2.charAt(right)-'a'] += 1;
            hash[s2.charAt(left)-'a']-=1;
            left += 1;
        }
        return false;
    }
    
    public static boolean areEqual(int[] arr1, int[] arr2)
    {
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]!=arr2[i])
                return false;
        }
        return true;
    }
}
