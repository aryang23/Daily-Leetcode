class Solution {
    public int garbageCollection(String[] g, int[] travel) {
        int lastM = 0, lastG = 0, lastP = 0;
        int countM = 0, countG = 0, countP = 0;
        
        int t = travel.length;
        int[] pref = new int[t+1];
        pref[0] = 0;
        for(int i=1; i<=t; i++) {
            pref[i]  = pref[i-1] + travel[i-1];
        }
        for(int i=0; i<g.length; i++) {
            char[] chArr = g[i].toCharArray();
            for(char ch:chArr) {
                if(ch=='G') {
                    countG++;
                    lastG = i;
                } else if(ch=='M') {
                    countM++;
                    lastM = i;
                } else {
                    countP++;
                    lastP = i;
                }
            }
        }
        
        int ans = 0;
        if(countM > 0) {
            ans += (countM+ pref[lastM]);
        }
        if(countG > 0) {
            ans += (countG+ pref[lastG]);
        }
        if(countP > 0) {
            ans += (countP+ pref[lastP]);
        }
        return ans;
    }
}
