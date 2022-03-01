class Solution {
    public int[] countBits(int n) {
        
        int[] arr = new int[n+1];
        int arrPtr = 0;
        
        for(int i=0;i<=n;i++)
        {
            int sa = countSetBits(i);
            arr[arrPtr]=sa;
            arrPtr++;
        }
        
        return arr;
        
    }
    
    public int countSetBits(int n)
    {
        int count = 0;
        while(n != 0)
        {
            count++;
            n&=(n-1);
        }
        return count;
    }
}