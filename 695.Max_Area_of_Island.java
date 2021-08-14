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
