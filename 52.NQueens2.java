class Solution {
    static boolean[] col, diag, adiag;
    public int totalNQueens(int n) {
        if(n==1)
            return 1;
        int m = n;
        col = new boolean[n];
        
        diag = new boolean[n+m-1];
        adiag = new boolean[n+m-1];
        int ans = totalNQueensHelper(n, m, 0, n);
        return ans;
    }
    
    public static int totalNQueensHelper(int n, int m, int floor, int tnq)
    {
        if(tnq==0)
        {
            return 1;
        }
        
        int count = 0;
        for(int room = 0; room<m; room++)
        {
            int r = floor, c = room;
            if(!col[c] && !diag[r+c] && !adiag[r - c + m - 1] )
            {
                col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += totalNQueensHelper(n, m, floor + 1, tnq-1);
                col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }
        
        return count;
    }
}
