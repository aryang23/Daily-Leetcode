class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int count = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1' && !visited[i][j])
                {
                    numIslandsHelper(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void numIslandsHelper(char[][] grid, boolean[][] visited, int i, int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j]==true || grid[i][j]=='0')
            return;
        
        visited[i][j] = true;
        numIslandsHelper(grid, visited, i-1, j);
        numIslandsHelper(grid, visited, i, j+1);
        numIslandsHelper(grid, visited, i+1, j);
        numIslandsHelper(grid, visited, i, j-1);
    }
}
