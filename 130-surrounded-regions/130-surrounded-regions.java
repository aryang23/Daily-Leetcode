class Solution {
    public void bfs(char [][]board,int i,int j)
    {
        // These two arrays are used to traverse four directions of a particular cell.
         int []dx={-1,0,1,0};
         int []dy={0,1,0,-1};
         Queue<ArrayList<Integer>>queue=new LinkedList<>();
        // Add the current cell to queue
         queue.add(new ArrayList<>(Arrays.asList(i,j)));
        // Do BFS until queue is empty
          while(!queue.isEmpty())
           {
                  // Retrieve first position in queue
                  ArrayList<Integer>temp=queue.poll();
                  int curx=(int)temp.get(0);
                  int cury=(int)temp.get(1);
                  // Mark it as '1'
                  board[curx][cury]='1';
                  // Mark four cells which are connected to current cell to '1' if cell has 'O' and push it to queue.
                  for(int i1=0;i1<4;i1++)
                  {
                      if(curx+dx[i1]<board.length && curx+dx[i1]>=0 && cury+dy[i1]<board[0].length && cury+dy[i1]>=0)
                      {
                          
                           if(board[curx+dx[i1]][cury+dy[i1]]=='O'){
                           board[curx+dx[i1]][cury+dy[i1]]='1';
                           queue.add(new ArrayList<>(Arrays.asList(curx+dx[i1],cury+dy[i1])));
                          }
                      }
                  }
                  
           }
    }
    public void solve(char[][] board) {
        
            // Traversing on 1st row
            for(int j=0;j<board[0].length;j++)
            {
                // If we found an 'O' on border, we need to make all its connected 'O's to '1's.
                 if(board[0][j]=='O')
                 {
                   bfs(board,0,j);   
                 }
            }
           // Traversing on last row
            for(int j=0;j<board[0].length;j++)
            {
                // If we found an 'O' on border, we need to make all its connected 'O's to '1's.
                if(board[board.length-1][j]=='O')
                    bfs(board,board.length-1,j);
            } 
           // Traversing on first column
            for(int i=0;i<board.length;i++)
            {
                // If we found an 'O' on border, we need to make all its connected 'O's to '1's.
                if(board[i][0]=='O')
                      bfs(board,i,0);
            }
           // Traversing on last column
            for(int i=0;i<board.length;i++)
            {
                // If we found an 'O' on border, we need to make all its connected 'O's to '1's.
                    if(board[i][board[0].length-1]=='O')
                          bfs(board,i,board[0].length-1);
            }
           // Traverse the grid again and perform step 2
            for(int i=0;i<board.length;i++)
            {
                for(int j=0;j<board[0].length;j++)
                {
                    if(board[i][j]=='O')
                        board[i][j]='X';
                  else  if(board[i][j]=='1')
                        board[i][j]='O';
                }
            }
    }
}
