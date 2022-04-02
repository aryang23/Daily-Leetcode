class Solution {
    public boolean validPalindrome(String s) {
        
        // if(isPalindrome(s)==true)
        //     return true;
        
        int i = 0, j = s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else
            {
                //2 Cases
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j-1);
            }
        }
        return true;
    }
    
    public boolean isPalindrome(String s,int start, int end)
    {
        while(start<end)
        {
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
}