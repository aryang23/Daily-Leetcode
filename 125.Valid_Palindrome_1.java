class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++)
        {
            if(Character.isLetterOrDigit(s.charAt(i)))
            {
                sb.append(s.charAt(i));
            }
        }
        
        s = sb.toString();
        s = s.toLowerCase();
        System.out.println(s);
        
        return isPalindromeHelper(s);
    }
    
    public boolean isPalindromeHelper(String s)
    {
        int start = 0, end = s.length()-1;
        while(start<=end)
        {
            if(s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }
}
