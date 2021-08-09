class Solution {
    
    public class Pair{
        int r = 0;
        int c = 0;

        Pair(int r,int c)
        {
            this.r = r;
            this.c = c;
        }
    }
    
    public void solveSudoku2(char[][] board) {
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                {
                    arr.add(new Pair(i, j));
                }
            }
        }

        solveSudoku(board, 0, arr);
    }
    
    public void solveSudoku(char[][] board)
    {
        rows = new int[9];
        cols = new int[9];
        mat = new int[3][3];
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                {
                    arr.add(new Pair(i, j));
                }
                else
                {
                    int mask = (1<<(board[i][j]-'0'));
                    rows[i]^=mask;
                    cols[j]^=mask;
                    mat[i/3][j/3]^=mask;
                }
            }
        }

        // solveSudoku(board, 0, arr);
        solveSudokuBits(board, 0, arr);
    }
    
    
    
    public boolean solveSudoku(char[][] board, int idx, ArrayList<Pair> arr)
    {
        if(idx==arr.size())
        return true;

        Pair p = arr.get(idx);
        int r = p.r;
        int c = p.c;

        for(int num = 1;num<=9;num++)
        {
            if(isValidToPlaceTheNumber(board,r,c,num))
            {
                board[r][c]=(char)(num+'0');
                if(solveSudoku(board, idx+1, arr))
                return true;
                board[r][c] = '.';
            }
        }

        return false;
    }
    
    public boolean isValidToPlaceTheNumber(char[][] board, int r,int c,int num)
    {
        int n = board.length, m = board[0].length;

        //Row Check
        for(int i=0;i<m;i++)
        {
            if(board[r][i]-'0'==num)
            return false;
        }

        //Col Check
        for(int i=0;i<n;i++)
        {
            if(board[i][c]-'0'==num)
            return false;
        }

        //SubMatrix
        r = (r/3)*3;
        c = (c/3)*3;

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[r+i][c+j]-'0'==num)
                return false;
            }
        }

        return true;
    }
    
    
    
    public int[] rows, cols;
    public int[][] mat;    
    public boolean solveSudokuBits(char[][] board, int idx, ArrayList<Pair> arr)
    {
        if(idx==arr.size())
        return true;

        Pair p = arr.get(idx);
        int r = p.r;
        int c = p.c;
        // System.out.println(1);
        for(int num = 1;num<=9;num++)
        {
            int mask = (1<<num);
            if((rows[r] & mask)==0 && (cols[c] & mask)==0 && (mat[r/3][c/3] & mask)==0)
            {
                rows[r]^=mask;
                cols[c]^=mask;
                mat[r/3][c/3]^=mask;
                board[r][c]=(char)(num+'0');

                if(solveSudokuBits(board, idx+1, arr))
                return true;

                board[r][c] = '.';
                rows[r]^=mask;
                cols[c]^=mask;
                mat[r/3][c/3]^=mask;
            }
        }

        return false;
    }
}

//99% Optimized
