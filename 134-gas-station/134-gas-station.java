class Solution {
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i=0; i<n; i++) {
            int total = 0, stopCount = 0, j = i;
            while(stopCount < n) {
                total += gas[j%n] - cost[j%n];
                if(total < 0)
                    break;
                stopCount++;
                j++;
            }
            if(stopCount == n && total >= 0)
                return i;
        }
        return -1;
    }
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tank = 0, total = 0, index = 0;
        for(int i=0;i<n;i++) {
            int consume = gas[i] - cost[i];
            tank += consume;
            if(tank < 0) {
                index = i + 1;
                tank = 0;
            }
            total += consume;
        }
        return total<0?-1 : index;
    }
}