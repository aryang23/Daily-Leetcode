class Solution {
    static boolean[] col, diag, adiag;
    public List<List<String>> solveNQueens(int n) {
        int m = n;
//         col = new boolean[n];
        
//         diag = new boolean[n+m-1];
//         adiag = new boolean[n+m-1];
        // boolean[][] box = new boolean[n][m];
        String[][] mainBox = new String[n][m];
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                mainBox[i][j]=".";
            }
        }
        int ans = solveNQueensHelper2(mainBox, 0, n, res);
        // System.out.println(ans);
        return res;
    }
    
    public static boolean isSafeToPlaceQueen(String[][] box, int sr, int sc)
    {
        int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
        int n = box.length, m = box[0].length;
        for(int d =0;d<dir.length;d++)
        {
            for(int rad = 0;rad<=n;rad++)
            {
                int r = sr+rad*dir[d][0];
                int c = sc+rad*dir[d][1];
                if(r>=0 && c>=0 && r<n && c<m)
                {
                    if(box[r][c]=="Q")
                        return false;
                }
                else
                    break;
            }
        }
        return true;
    }
    
    public int solveNQueensHelper2(String[][] box, int bno, int tnq, List<List<String>> res)
    {
        if(tnq==0)
        {
            // System.out.println(asf);
            List<String> ba = new ArrayList<>();
            for(int i=0;i<box.length;i++)
            {
                // String base="";
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<box[0].length;j++)
                {
                    sb.append(box[i][j]);
                }
                ba.add(sb.toString());
            }
            res.add(ba);
            return 1;
        }
        
        int count = 0;
        int n = box.length, m = box[0].length;
        for(int b=bno;b<n*m;b++)
        {
            int r = b/m;
            int c = b%m;
            if(isSafeToPlaceQueen(box, r, c))
            {
                // box[r][c] = true;
                box[r][c]="Q";
                count+=solveNQueensHelper2(box, b+1, tnq-1, res);
                // box[r][c] = false;
                box[r][c]=".";
            }
        }
        return count;
    }
}