class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        
        int[] hash = new int[26];
        int[] phash = new int[26];
        
        int window = p.length();
        int len = s.length();
        
        if(len < window)
            return ans;
        
        int left=0, right = 0;
        
        while(right < window) {
            phash[p.charAt(right)-'a']+=1;
            hash[s.charAt(right++)-'a'] += 1;
        }
        
        right-=1;
        while(right < len) {
            if(areEqual(hash, phash))
                ans.add(left);
            right++;
            if(right != len) 
                hash[s.charAt(right)-'a'] += 1;
            hash[s.charAt(left)-'a'] -= 1;
            left++;
        }
        return ans;
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