class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxCount = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]!=0 && !visited[i][j])
                {
                    int count = 0;
                    int count2 = 0;
                    count2 = maxAreaOfIslandHelper(grid, visited, i, j);
                    if(count2 > maxCount)
                        maxCount = count2;
                }
            }
        }
        return maxCount;
    }
    
    public int maxAreaOfIslandHelper(int[][] grid, boolean[][] visited, int i, int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j]==true || grid[i][j]==0)
            return 0;
        
        int count = 1;
        visited[i][j] = true;
        count += maxAreaOfIslandHelper(grid, visited, i-1, j);
        count += maxAreaOfIslandHelper(grid, visited, i, j+1);
        count += maxAreaOfIslandHelper(grid, visited, i+1, j);
        count += maxAreaOfIslandHelper(grid, visited, i, j-1);
        
        return count;
    }
}







//M-2

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
