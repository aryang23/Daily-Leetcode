class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int ans = Math.max(solution(nums, firstLen, secondLen), solution(nums, secondLen, firstLen));
        return ans;
    }
    
    public int solution(int[] arr, int x, int y){
		// write your code here
		int n = arr.length;
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];
		
		int sum = 0;
		for(int i=0; i<x; i++) {
		    sum += arr[i];
		}
		
		dp1[x-1] = sum;
		
		for(int i=x; i < n; i++) {
		    sum = sum + arr[i] - arr[i-x];
		    dp1[i] = Math.max(dp1[i-1], sum);
		}
		
		sum = 0;
		for(int i=n-1; i>=n-y;i--) {
		    sum += arr[i];
		}
		dp2[n-y] = sum;
		for(int i=n-y-1; i>= 0; i--) {
		    sum = sum + arr[i] - arr[i+y];
		    dp2[i] = Math.max(dp2[i+1], sum);
		}
		
		int ans = 0;
		for(int i=x-1; i<n-y; i++) {
		    ans = Math.max(ans, dp1[i] + dp2[i+1]);
		}
		
		return ans;
	}
}