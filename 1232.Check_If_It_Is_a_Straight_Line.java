class Solution {
    public boolean checkStraightLine(int[][] cord) {
        int n = cord.length;
        System.out.println(n);
        if(cord==null || cord[0].length==0)
            return false;
        if(n<3)
            return true;
        
        int[] p = cord[0];
        int[] q = cord[1];
        
        for(int i=2;i<n;i++)
        {
            int[] curr = cord[i];
            if((curr[0] - p[0]) * (q[1] - p[1]) != (curr[1] - p[1]) * (q[0] - p[0]))
                return false;
        }
        return true;
    }
}
