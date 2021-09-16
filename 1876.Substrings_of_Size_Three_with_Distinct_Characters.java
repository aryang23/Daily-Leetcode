class Solution {
    
    public int countGoodSubstrings(String s){
        int n = s.length();
        if(n==1 || n==2)
            return 0;
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        
        int left=0, count=0;
        while(left < n)
        {
            for(int i=left;i<left+3 && left+2<n;i++)
            {
                Character ch = s.charAt(i);
                map.put(ch, i);
            }
            if(map.size()==3)
                count++;
            left++;
            map = new HashMap<>();
        }
        return count;
    }
}
