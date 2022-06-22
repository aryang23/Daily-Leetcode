class Solution {
    public static class Pair {
        int i;
        int j;
        int lvl;
        
        Pair(){
            
        }
        
        Pair(int i, int j, int lvl) {
            this.i = i;
            this.j = j;
            this.lvl = lvl;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] ans = new int[n][m];
        
        ArrayDeque<Pair> q = new ArrayDeque<>();
        
        //Inserting All Zeros in Queue
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                } else {
                    ans[i][j] = -1;
                }
            }
        }
        
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        //BFS From All 1
        while(q.size() > 0) {
            Pair rem = q.remove();
            
            for(int k=0; k<4; k++) {
                int ni = rem.i + dir[k][0];
                int nj = rem.j + dir[k][1];
                
                if(ni>=0 && ni<n && nj>=0 && nj<m && ans[ni][nj] == -1) {
                    q.add(new Pair(ni, nj, rem.lvl + 1));
                    ans[ni][nj] = rem.lvl + 1;
                }
            }
        }
        return ans;
    }
}