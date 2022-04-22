// { Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        int te = r*c;
        int ce = 1;
        // int[] ans = new int[te
        ArrayList<Integer> ans = new ArrayList<>();
        
        int sr = 0, sc = 0, er = r - 1, ec = c - 1, k = 0;
        while(k < te) {
            for(int i=sc; i<=ec && k<te; i++) {
                ans.add(matrix[sr][i]);
                k++;
            }
            sr++;
            for(int i=sr; i<=er && k<te; i++) {
                ans.add(matrix[i][ec]);
                k++;
            }
            ec--;
            for(int i=ec; i>=sc && k<te; i--) {
                ans.add(matrix[er][i]);
                k++;
            }
            er--;
            for(int i=er; i>=sr && k<te; i--) {
                ans.add(matrix[i][sc]);
                k++;
            }
            sc++;
        }
        // System.out.println(k);
        return ans;
    }
}
