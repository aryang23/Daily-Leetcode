class Solution {
    int dp[][];
    int totalline;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp=new int[200][200];
        for(int row[]: dp){
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        
        totalline=triangle.size();
        return MinPath(triangle,0,0);
    }
    
    public int MinPath(List<List<Integer>> triangle, int line, int i){
        
        if(line>=totalline || i>=triangle.get(line).size()){
            return 0;
        }
        
        if(dp[line][i]!=Integer.MIN_VALUE){
            return dp[line][i];
        }
        
        int Left = MinPath(triangle,line+1,i);
        int Right = MinPath(triangle,line+1,i+1);
        
        return dp[line][i]=triangle.get(line).get(i)+Math.min(Left,Right);
    }
}
