class Solution {
    public double knightProbability(int n, int k, int r, int c) {
        int[][] moves = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
		double[][] dp1 = new double[n][n];
		double[][] dp2 = new double[n][n];
		
		dp1[r][c] = 1.0;
		
		//8 choices
		
		for(int l=0; l<k; l++) {
		    for(int i=0; i<n; i++) {
		        for(int j=0; j<n; j++) {
		            if(dp1[i][j] > 0) {
		                for(int m=0; m<8; m++) {
		                    int ni = i + moves[m][0];
		                    int nj = j + moves[m][1];
		                    if(ni>=0 && nj>=0 && ni<n && nj<n) {
		                        dp2[ni][nj] += dp1[i][j]*1/8;
		                    }
		                }
		            }
		        }
		    }
		    dp1 = dp2;
		    dp2 = new double[n][n];
		}
		
		double ans = 0;
		for(int i=0; i<n; i++) {
		    for(int j=0; j<n; j++) {
		        ans += dp1[i][j];
		    }
		}
		return ans;
    }
}