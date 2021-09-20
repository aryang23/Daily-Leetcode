class Solution {
    public String tictactoe(int[][] moves) {
        
        char[][] board = new char[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                board[i][j] = '.';
        }
        for(int i=0;i<moves.length;i++)
        {
            int r = moves[i][0];
            int c = moves[i][1];
            if(i%2==0)
                board[r][c] = 'X';
            else
                board[r][c] = 'O';
        }
        
        return whoWins(board);
    }
    public String whoWins(char[][] board)
    {
        //Row Checking
        boolean whoWin = false;
        int n = board.length, m = board[0].length;
        for(int i=0;i<n;i++)
        {
            
            int xCount = 0, oCount = 0;
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='X')
                    xCount++;
                else if(board[i][j]=='O')
                    oCount++;
            }
            if(xCount==n)
                return "A";
            if(oCount==m)
                return "B";
        }
        
        //Col Checking
        for(int j=0;j<m;j++)
        {
            int xCount = 0, oCount = 0;
            for(int i=0;i<n;i++)
            {
                if(board[i][j]=='X')
                    xCount++;
                else if(board[i][j]=='O')
                    oCount++;
            }
            if(xCount==n)
                return "A";
            if(oCount==m)
                return "B";
        }
        
        //Diagonal Checking
        if(board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X')
            return "A";
        if(board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O')
            return "B";
        
        //Reverse Diagonal Checking
        if(board[2][0]=='X' && board[1][1]=='X' && board[0][2]=='X')
            return "A";
        if(board[2][0]=='O' && board[1][1]=='O' && board[0][2]=='O')
            return "B";
        
        int c = 0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]!='.')
                    c++;
            }
        }
        if(c!=9)
            return "Pending";
        return "Draw";
    }
}
