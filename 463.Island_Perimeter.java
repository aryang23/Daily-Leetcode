class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    return dfs(grid, i, j, visited);
                }
            }
        }
        return 0;
    }
    
    private int dfs(int[][] grid, int i, int j, boolean[][] visited)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0)
            return 1;
        
        if(visited[i][j])
            return 0;
        
        visited[i][j] = true;
        return dfs(grid, i-1, j, visited)+ dfs(grid, i+1, j, visited) + dfs(grid, i, j-1, visited) + dfs(grid, i, j+1, visited);
    }
}
