class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        if(s.length() != t.length())
            return false;
        int n = s.length();
        for(int i=0; i<n; i++) {
            if(sArr[i] != tArr[i])
                return false;
        }
        return true;
    }
}