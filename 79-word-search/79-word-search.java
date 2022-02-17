class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    boolean ans = existHelper2(board, word, i, j, 0, visited);
                    if(ans==true)
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean existHelper2(char[][] board, String word, int r, int c, int idx, boolean[][] visited)
    {
        if(idx==word.length())
            return true;
        
        
        int sr = r, sc = c;
        if(sr>=0 && sc>=0 && sr<board.length && sc<board[0].length && visited[sr][sc]!=true)
        {
            if(board[sr][sc]==word.charAt(idx))
            {
                visited[sr][sc] = true;
                
                //Up
                boolean sa = existHelper2(board, word, sr-1, sc, idx+1, visited);
                if(sa==true)
                    return true;
                        
                //Right
                sa = existHelper2(board, word, sr, sc+1, idx+1, visited);
                if(sa==true)
                    return true;
                        
                //Down
                sa = existHelper2(board, word, sr+1, sc, idx+1, visited);
                if(sa==true)
                    return true;
                        
                //Left
                sa = existHelper2(board, word, sr, sc-1, idx+1, visited);
                if(sa==true)
                    return true;
                        
                visited[sr][sc] = false;
            }
        }
            
        return false;
    }
}