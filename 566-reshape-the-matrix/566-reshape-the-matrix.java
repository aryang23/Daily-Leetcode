class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] ans = new int[r][c];
        int n = mat.length, m = mat[0].length;
        if(n*m != r*c)
            return mat;
        List<Integer> res = new ArrayList<>();
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                res.add(mat[i][j]);
            }
        }
        
        int k=0;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                ans[i][j] = res.get(k++);
            }
        }
        
        return ans;
    }
}