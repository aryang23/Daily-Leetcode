class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0, right = (long)(Math.sqrt(c));
        while(left<=right)
        {
            long total = left*left+right*right;
            if(total==c)
                return true;
            else if(total>c)
                right--;
            else
                left++;
        }
        return false;
    }
}
