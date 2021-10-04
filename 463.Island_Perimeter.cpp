class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
    	int cnt=0,count=0,row=grid.size(),cols=grid[0].size();
    	for(int i=0;i<row;i++)
    	{
    		for(int j=0;j<cols;j++)
    		{
    			if(grid[i][j]==1)
    			{
    				cnt++;
				
                    if(j+1<cols and grid[i][j+1]==1)
                        count++;
                    if(i+1<row and grid[i+1][j]==1)
                        count++;
                    if(j-1>=0 and grid[i][j-1]==1)
                        count++;
                    if(i-1>=0 and grid[i-1][j]==1)
                        count++;
			}
			}
		}
		return 4*cnt-count;
        }
};
