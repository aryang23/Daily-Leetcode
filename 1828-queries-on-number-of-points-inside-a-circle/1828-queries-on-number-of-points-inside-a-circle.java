class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        int i=0;
        for(int[] circle:queries)
        {
            int x = circle[0];
            int y = circle[1];
            int rad = circle[2];
            int count = 0;
            for(int[] p:points)
            {
                int xp = p[0];
                int yp = p[1];
                double dist = (((xp-x)*(xp-x))+((yp-y)*(yp-y)));
                dist = (double)Math.sqrt(dist);
                if(dist<=rad)
                    count++;
            }
            ans[i] = count;
            i++;
        }
        return ans;
    }
}