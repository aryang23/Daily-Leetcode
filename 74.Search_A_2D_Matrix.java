class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0)
            return false;
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int start = 0, end = n*m-1;
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(matrix[mid/m][mid%m]==target)
                return true;
            else if(matrix[mid/m][mid%m]<target)
                start = mid+1;
            else
                end = mid-1;
        }
        return false;
        
    }
}
