class Solution {
    static boolean[] col, diag, adiag;
    public int totalNQueens(int n) {
        if(n==1)
            return 1;
        int m = n;
        col = new boolean[n];
        
        diag = new boolean[n+m-1];
        adiag = new boolean[n+m-1];
        int ans = totalNQueensHelper2(n, 0, n);
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
    
    static int r = 0, c = 0, d = 0, ad = 0;
    public static int totalNQueensHelper2(int n, int floor, int tnq)
    {
        if(tnq==0)
        {
            return 1;
        }
        
        int count = 0;
        for(int room = 0; room<n; room++)
        {
            int row = floor, col = room;
            //Checking for false of all
            if((c&(1<<col))==0 && (d&(1<<(row+col))) == 0 && (ad&(1<<(row-col+n-1))) == 0)
            {
                //All are 0, so taking xor, means all will be marked as true
                c ^= (1<<col);
                d ^= (1<<(row+col));
                ad ^= (1<<(row-col+n-1));
                count += totalNQueensHelper2(n, floor+1, tnq-1);
                //All are 1, so taking xor, means all will be marked as false
                c ^= (1<<col);
                d ^= (1<<(row+col));
                ad ^= (1<<(row-col+n-1));
            }
        }
        return count;
    }
    
    
}
