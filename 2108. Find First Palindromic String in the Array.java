class Solution {
    public String firstPalindrome(String[] words) {
        for(String word:words)
        {
            if(isPal(word) == true)
                return word;
        }
        return "";
    }
    public boolean isPal(String word)
    {
        int n = word.length();
        for(int i=0;i<n/2;i++)
        {
            if(word.charAt(i) != word.charAt(n-i-1))
                return false;
        }
        return true;
    }
}
