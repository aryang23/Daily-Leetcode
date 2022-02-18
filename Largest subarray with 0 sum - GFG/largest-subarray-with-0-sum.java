// { Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        int[] psum = new int[n];
        psum[0] = arr[0];
        for(int i=1; i<n; i++) {
            psum[i] = psum[i-1] + arr[i];
        }
        
        HashMap<Integer, Integer> map = new HashMap<>(); //PrefixSum vs FirstIdx
        map.put(0, -1);
        int olen = 0;
        for(int i=0; i<n; i++) {
            int val = psum[i];
            if(map.containsKey(val) == true) {
                int len = i - map.get(val);
                olen = Math.max(olen, len);
            } else {
                map.put(val, i);
            }
        }
        return olen;
        
    }
}