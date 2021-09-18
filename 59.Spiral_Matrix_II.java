class Solution {
    public int[][] generateMatrix(int n) {
        int num=1;
        int total = n*n;
        int[][] mat = new int[n][n];
        int sr=0, sc=0, er=n-1, ec=n-1;
        while(num<=total)
        {
            //First Row
            for(int i=sr;i<=er && num<=total;i++)
            {
                mat[sc][i]=num;
                num++;
            }
            sr++;
            
            //Last Col
            for(int i=sr;i<=er && num<=total;i++)
            {
                mat[i][ec] = num;
                num++;
            }
            ec--;
            
            //Last Row
            for(int i=ec;i>=sc && num<=total;i--)
            {
                mat[er][i] = num;
                num++;
            }
            er--;
            
            //First Col
            for(int i=er;i>=sr && num<=total;i--)
            {
                mat[i][sc]=num;
                num++;
            }
            sc++;
        }
        return mat;
    }
}
