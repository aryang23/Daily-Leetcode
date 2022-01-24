		class Solution {
    static long MOD = ((int)1e9 + 7);
    public static long mod_add(long a, long b) {
        return (a % MOD + b % MOD + MOD) % MOD;
    }
    public static long mod_mul(long a, long b) {
        long res = 0;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) > 0) {
                res = mod_add(res, a);
            }
            a = (2 * a) % MOD;
            b >>= 1;
        }
        return res;
    }
    public int kadanes2(int[] arr) {
        int sum = 0;
        int osum = 0;
        for(int i=0; i<2*arr.length; i++) {
            int val = arr[i%arr.length];
            if(sum < 0) sum = 0;
            sum += val;
            osum = Math.max(osum, sum);
        }
        return osum;
    }
    public int kadanes(int[] arr) {
        int sum = 0;
        int osum = 0;
        for(int val : arr) {
            if(sum < 0) sum = 0;
            sum += val;
            osum = Math.max(osum, sum);
        }
        return osum;
    }
    public int kConcatenationMaxSum(int[] arr, int k) {
        int sum = 0;
        for(int val : arr) sum+=val;
        if(k == 1) {
            return kadanes(arr);
        } 
        long ans = mod_add(mod_mul(Math.max(0, sum), k-2), kadanes2(arr));
        return (int)(ans);
    }
}

