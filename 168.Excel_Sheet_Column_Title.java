class Solution {
    public String convertToTitle2(int n) {
        
        StringBuilder sb = new StringBuilder();
        while(n>0)
        {
            n--;
            sb.append((char)('A'+n%26));
            n/=26;
        }
        sb.reverse();
        return sb.toString();
    }
    
    public String convertToTitle(int n){
        return n == 0 ? "" : convertToTitle((n - 1) / 26) + (char) ((n - 1) % 26 + 'A');
    }
}
