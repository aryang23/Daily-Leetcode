class Solution {
    public boolean isVowel(char c)
    {
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
            return true;
        return false;
    }
    public String reverseVowels2(String s) {
        
        int l=0, h=s.length() - 1;
        s.toLowerCase();
        
        char[] c = s.toCharArray();
        
        while(h>l)
        {
            while(!isVowel(c[l]) && l<h){
                l++;
            }
            
            while(!isVowel(c[h]) && l<h){
                h--;
            }
            
            char temp = c[l];
            c[l] = c[h];
            c[h] = temp;
            l++;
            h--;
        }
        return String.valueOf(c);
    }
    
    
    public String reverseVowels(String s){
        int l=0, h=s.length() - 1;
        s.toLowerCase();
        
        char[] c = s.toCharArray();
        
        while(h > l)
        {
            while(!isVowel(c[l]) && l<h){
                l++;
            }
            
            while(!isVowel(c[h]) && l<h){
                h--;
            }
            
            char temp = c[l];
            c[l] = c[h];
            c[h] = temp;
            l++;
            h--;
        }
        return String.valueOf(c);
    }
}