class Solution {
    
    int solve(int arr[], int i, Map<Integer,Integer> dp){
        if(i>=arr.length) return 0;
        if(dp.containsKey(i)) return dp.get(i);
        if(arr[i]==0){
            int ans = solve(arr,i+1,dp);
            dp.put(i,ans);
            return ans;
        }
        int ans = Math.max(arr[i]*i+solve(arr,i+2,dp),solve(arr,i+1,dp));
        dp.put(i,ans);
        return ans;
    }
    
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i: nums) max = Math.max(max,i);
        int arr[] = new int[max+1];
        for(int i: nums) arr[i]++;
        Map<Integer,Integer> dp = new HashMap<>();
        return solve(arr,0,dp);
    }
}