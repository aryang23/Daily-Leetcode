class Solution {
    public String reverseWords(String s) {
        
        String[] list = s.split(" ");
        String ans = "";
        
        for(int i=0;i<list.length;i++)
        {
            String str = list[i];
            String res = new StringBuilder(str).reverse().toString();
            ans += res + " ";
        }
        
        ans = ans.trim();
        return ans;
    }
}