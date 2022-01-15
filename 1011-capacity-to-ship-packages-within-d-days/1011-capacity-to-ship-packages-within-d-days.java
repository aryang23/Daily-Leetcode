class Solution {
    public int shipWithinDays(int[] pages, int m) {
        int n = pages.length;
        if(m>n)
        {
            return -1;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int val : pages){
            sum += val;
            max = Math.max(max, val);
        }
        
        int lo = max;
        int hi = sum;
        
        int burden = Integer.MAX_VALUE;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(isBurdenPossible(pages, mid, m) == true){
                burden = mid;
                hi = mid-1;
            } else {
                lo = mid + 1;
            }
        }
        return burden;
    }
    private static boolean isBurdenPossible(int[] pages, int burden, int m) {
        int student = 1;
        int sum = 0;
        
        for(int i=0;i<pages.length;i++) {
            sum += pages[i];
            if(sum > burden) {
                student++;
                sum = pages[i];
            }
            
        }
        return student <= m;
    }
}