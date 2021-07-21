class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for(int i=0;i<grid.length;i++)
		{
		    for(int j=0;j<grid[0].length;j++)
		    {
		        if(grid[i][j]!=0)
		        {
		            boolean[][] vis = new boolean[grid.length][grid[0].length];
    		        int ans = getMaxGoldHelper(grid, i, j, vis);
    		        if(ans > max)
    		        {
    		            max = ans;
    		        }   
		        }
		    }
		}
        
        return max;
        
    }
    
    public static int getMaxGoldHelper(int[][] arr,int sr,int sc, boolean[][] vis)
	{
	    if(sr<0 || sc<0 || sr>=arr.length || sc>=arr[0].length || arr[sr][sc]==0 || vis[sr][sc]==true)
	    {
	        return 0;
	    }
	    
	    vis[sr][sc] = true;
	    int opt1 = getMaxGoldHelper(arr, sr, sc-1, vis);
	    int opt2 = getMaxGoldHelper(arr, sr, sc+1, vis);
	    int opt3 = getMaxGoldHelper(arr, sr - 1, sc, vis);
	    int opt4 = getMaxGoldHelper(arr, sr + 1, sc, vis);
	    vis[sr][sc] = false;
	    
	    int mainOpt1 = Math.max(opt1, opt2);
	    int mainOpt2 = Math.max(opt3, opt4);
	    int ans = Math.max(mainOpt1, mainOpt2)+arr[sr][sc];
	    return ans;
	}
}
