class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        // int ans = singleComb(time, 60, 0, 0, 0);
        // return ans;
        
        //Working Fine
        //Nice Approach
        int remainders[] = new int[60];
        int count = 0;
        for(int t:time)
        {
            if(t%60==0)
            {
                count += remainders[0];
            }
            else
            {
                count += remainders[60 - t % 60];
            }
            remainders[t%60]++;
        }
        return count;
    }
    
    //Working fine for some test cases, bt for large values, it is giving TLE as 2^n
    public int singleComb(int[] time, int tar, int idx, int len, int sum)
    {
        if(len==2)
        {
            if(sum%tar==0)
                return 1;
            return 0;
        }
        int count = 0;
        for(int i=idx;i<time.length;i++)
        {
            if(len<2)
            {
                count+=singleComb(time, tar, i+1, len+1, sum+time[i]);
            }
        }
        return count;
    }
}
