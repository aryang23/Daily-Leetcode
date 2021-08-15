class Solution {
    public int findTheWinner(int n, int k) {
        if(k>n)
            k=k%n;
        return solution(n, k)+1;
    }
    int solution(int n, int k)
    {
        if(n==1)
            return 0;
        int x = solution(n-1, k);
        int y = (x+k)%n;
        return y;
    }
}
