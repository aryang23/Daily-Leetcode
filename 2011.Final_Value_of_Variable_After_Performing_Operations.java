class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for(String str:operations)
        {
            if(str.charAt(0)=='+' || str.charAt(2)=='+')
                ans++;
            else
                ans--;
        }
        return ans;
    }
}
