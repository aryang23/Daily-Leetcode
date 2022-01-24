class Solution {
    public static int[] solution(int[] arr, int k){
		// write your code here
		int n = arr.length;
		int[] psum = new int[n];
		psum[0] = arr[0];
		for(int i=1; i<n; i++) {
		    psum[i] = psum[i-1] + arr[i];
		}
		
		int[] left = new int[n];
		int[] right = new int[n];
		
		int sum = 0;
		for(int i=0; i<k; i++) {
		    sum += arr[i];
		}
		
		left[k-1] = sum;
		
		for(int i=k;i<n;i++) {
		    sum = sum + arr[i] - arr[i-k];
		    left[i] = Math.max(left[i-1], sum);
		}
		
		sum = 0;
		for(int i=n-1; i>=n-k; i--) {
		    sum += arr[i];
		}
		right[n-k]= sum;
		for(int i=n-k-1; i>=0; i--) {
		    sum = sum + arr[i] - arr[i + k];
		    right[i] = Math.max(right[i+1], sum);
		}
		
		int ans = 0;
		int spma = -1;
		int lsum = 0;
		int rsum = 0;
		//Starting pt of middle subarray vres fro k to n-2*k
		
		
		for(int i=k; i<=n-2*k; i++) {
		    if(left[i-1]+ psum[i+k-1]-psum[i-1]+ right[i+k] > ans) {
		        lsum = left[i-1];
		        rsum = right[i+k];
		        ans = left[i-1]+ psum[i+k-1]-psum[i-1]+ right[i+k];
		        spma = i;
		    }
		}
		
		System.out.print(ans + " ");
		int si = -1;
		for(int i= k-1; i<n; i++) {
		    if(left[i] == lsum) {
		        // System.out.print((i-k+1)+" ");
                si = i - k + 1;
		        break;
		    }
		}
		
		System.out.print(spma+" ");
		int ei = -1;
		for(int i=spma+k; i < n ; i++) {
		    if(psum[i+k-1] - psum[i-1] == rsum) {
                ei = i;
		        // System.out.print(i);
		        break;
		    }
		}
        
        int[] res = new int[3];
        res[0] = si;
        res[1] = spma;
        res[2] = ei;
        return res;
	}
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] ans = solution(nums, k);
        return ans;
    }
}