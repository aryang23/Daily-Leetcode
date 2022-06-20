class Solution {
    public int numEnclaves(int[][] grid) {
        
        int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if((i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1) && grid[i][j]==1) {
                    dfs(grid, dir, i, j);
                }
            }
        }
        
        int cnt = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]==1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    public void dfs(int[][] grid, int[][] dir, int sr, int sc)
    {
        grid[sr][sc] = 0;
        for(int d=0;d<4;d++)
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==1)
                dfs(grid, dir, r, c);
        }
    }
}