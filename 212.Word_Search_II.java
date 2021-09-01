//Code is correct, Giving TLE, M-1
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        for(int w=0;w<words.length;w++)
        {
            String word = words[w];
            for(int i=0;i<board.length;i++)
            {
                boolean isFilled = false;
                for(int j=0;j<board[0].length;j++)
                {
                    if(board[i][j]==word.charAt(0))
                    {
                        boolean[][] visited = new boolean[board.length][board[0].length];
                        boolean smallAns = existHelper2(board, word, i, j, 0, visited);
                        if(smallAns==true)
                        {
                            isFilled = true;
                            ans.add(word);
                            break;
                        }
                    }
                }
                if(isFilled==true)
                    break;
            }
        }
        return ans;
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
