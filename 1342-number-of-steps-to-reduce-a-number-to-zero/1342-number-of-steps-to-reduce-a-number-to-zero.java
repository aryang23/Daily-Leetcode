class Solution {
    public int numberOfSteps(int num) {
        if(num==0)
            return 0;
        int ans = 0;
        if(num%2==0)
            ans = numberOfSteps(num/2);
        else
            ans = numberOfSteps(num-1);
        return ans+1;
    }
}