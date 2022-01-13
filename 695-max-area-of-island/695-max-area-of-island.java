class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length, maxSize = 0;
        int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
        
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    int s = maxAreaOfIslandHelper(grid, dir, i, j);
                    maxSize = Math.max(maxSize, s);
                }
            }
        }
        return maxSize;
    }
    
    public int maxAreaOfIslandHelper(int[][] grid, int[][] dir, int sr, int sc)
    {
        grid[sr][sc] = 0;
        int size = 0;
        for(int d=0;d<4;d++)
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length &&  grid[r][c]==1)
                size += maxAreaOfIslandHelper(grid, dir, r, c);
        }
        
        return size + 1;
    }
}