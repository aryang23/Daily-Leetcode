class Solution {
    private int getNextNum(int n)
    {
        int totalSum = 0;
        while(n>0)
        {
            int d = n%10;
            n = n/10;
            totalSum+=d*d;
        }
        return totalSum;
    }
    public boolean isHappy(int n) {
        Set<Integer> present = new HashSet<>();
        while(n!=1 && !present.contains(n))
        {
            present.add(n);
            n = getNextNum(n);
        }
        return n==1;
        
    }
}
