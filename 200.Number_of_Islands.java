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










//Soln2: -
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length, componentCount = 0;
        int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(grid, dir, i, j);
                    componentCount++;
                }
            }
        }
        return componentCount;
    }
    
    public void dfs(char[][] grid, int[][] dir, int sr, int sc)
    {
        grid[sr][sc] = '0';
        for(int d=0;d<4;d++)
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]=='1')
                dfs(grid, dir, r, c);
        }
    }
}
