class Solution {
    public boolean checkValid(int[][] matrix) {
         Set<Integer> set = null;
        
        for(int i=0;i<matrix.length;i++)
        {
            set = new HashSet<>();
            for(int j=0;j<matrix[0].length;j++)
            {
                int el = matrix[i][j];
                if(set.contains(el))
                    return false;
                else
                    set.add(el);
            }
        }
        
        for(int j=0;j<matrix[0].length;j++)
        {
            set = new HashSet<>();
            for(int i=0;i<matrix.length;i++)
            {
                int el = matrix[i][j];
                if(set.contains(el))
                    return false;
                else
                    set.add(el);
            }
        }
        return true;
    }
}
