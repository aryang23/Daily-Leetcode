class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder("L" + dominoes + "R");
        int n = sb.length();
        int i = 0;
        while(i < n-1) {
            int j = i+1;
            
            while(j<n && sb.charAt(j)=='.') {
                j++;
            }
            
            //Solve Section from i to j
            section_solver(sb, i, j);
            i = j;
        }
        
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }
    
    public void section_solver(StringBuilder sb, int i, int j) {
        if(sb.charAt(i)=='L' && sb.charAt(j)=='L') {
            for(int k=i+1; k<=j-1; k++) {
                sb.setCharAt(k, 'L');
            }
        } else if(sb.charAt(i)=='R' && sb.charAt(j)=='R') {
            for(int k=i+1; k<=j-1; k++) {
                sb.setCharAt(k, 'R');
            }
        } else if(sb.charAt(i)=='L' && sb.charAt(j)=='R') {
            //Do Nothing
        } else if(sb.charAt(i)=='R' && sb.charAt(j)=='L') {
            int s = i + 1;
            int e = j - 1;
            
            while(s < e) {
                sb.setCharAt(s, 'R');
                sb.setCharAt(e, 'L');
                
                s++;
                e--;
            }
            if(s==e) {
                sb.setCharAt(s, '.');
            }
        }
    }
}