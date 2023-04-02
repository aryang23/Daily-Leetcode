class Solution {
    public int[] successfulPairs2(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int k = 0;
        int[] ra = new int[n];

        for(int i=0; i<n; i++) {
            int cv = spells[i];
            int j = 0;
            for(j=0; j<m; j++) {
                int cm = cv * potions[j];
                if(cm >= success) {
                    //All elements ahead in the list are also part of this
                    ra[k++] = (m - j);
                    break;
                }
            }
            if(j==m) {
                ra[k++] = 0;
            }
        }
        return ra;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int k = 0;
        int[] ra = new int[n];

        for(int i=0; i<n; i++) {
            long cv = spells[i];
            int j = 0;
            int lo = 0, hi = m-1, mid = 0;
            while(lo <= hi) {
                mid = (lo+hi)/2;
                if(c(potions[mid], cv, success)) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            ra[k++] = (m-lo);
        }
        return ra;
    }

    public static boolean c(int a, long b, long success) {
        long cm = (long)a*b;
        if(cm >= success) {
            return true;
        } else {
            return false;
        }
    }
}
