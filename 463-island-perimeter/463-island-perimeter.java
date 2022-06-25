class Solution {
    static int count;
    public int islandPerimeter(int[][] grid) {
        count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public static void dfs(int[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0) {
            count++;
            return;
        }
        if(grid[i][j] == 2) {
            return;
        }
        grid[i][j] = 2;
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        
    }
}