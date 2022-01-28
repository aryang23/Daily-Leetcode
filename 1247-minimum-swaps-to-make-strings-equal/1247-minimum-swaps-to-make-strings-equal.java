class Solution {
    public int minimumSwap(String s1, String s2) {
        int xy = 0, yx = 0;
        
        int n = s1.length(), m = s2.length();
        
        if(n!=m)
            return -1;
        
        for(int i=0; i<n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            if(c1=='x' && c2=='y') {
                xy++;
            }
            if(c1=='y' && c2=='x') {
                yx++;
            }
        }
        
        if((xy+yx)%2 != 0)
            return -1;
        
        return (xy/2+yx/2+xy%2+yx%2);
    }
}