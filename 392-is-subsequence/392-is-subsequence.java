class Solution {
    public boolean isSubsequence(String s, String t) {
        return isSubseq(s, t, 0, 0);
    }
    public boolean isSubseq(String s, String t, int idx1, int idx2) {
        if(idx1==s.length()) {
            return true;
        }
        if(idx2==t.length()) {
            return false;
        }
        
        
        boolean sa = false;
        if(s.charAt(idx1)==t.charAt(idx2)) {
            sa = isSubseq(s, t, idx1+1, idx2+1);
        } else {
            sa = isSubseq(s, t, idx1, idx2+1);
        }
        
        return sa;
    }
}