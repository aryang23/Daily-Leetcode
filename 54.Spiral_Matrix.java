class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int sr = 0, sc = 0, er = matrix.length-1, ec = matrix[0].length-1; 
        
        List<Integer> ans = new ArrayList<>();
        int counter = 1;
        int tn = matrix.length*matrix[0].length;
        while(counter<=tn)
        {
            for(int i=sc;i<=ec && counter<=tn;i++)
            {
                ans.add(matrix[sr][i]);
                counter++;
            }
            sr++;
            
            for(int i=sr;i<=er && counter<=tn;i++)
            {
                ans.add(matrix[i][ec]);
                counter++;
            }
            ec--;
            
            for(int i=ec;i>=sc && counter<=tn;i--)
            {
                ans.add(matrix[er][i]);
                counter++;
            }
            er--;
            
            for(int i=er;i>=sr && counter<=tn;i--)
            {
                ans.add(matrix[i][sc]);
                counter++;
            }
            sc++;
            
        }
        return ans;
    }
}
