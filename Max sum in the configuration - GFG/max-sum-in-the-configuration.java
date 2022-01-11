// { Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(new GfG().max_sum(arr,n));
			
		t--;
		}
	}
	
}
// } Driver Code Ends


class GfG
{
    int max_sum(int arr[], int n)
    {
	// Your code here
	        int sum = 0;
        int sIm1 = 0;
        for(int i=0;i<arr.length;i++)
        {
            sIm1 += arr[i] * i;
            sum += arr[i];
        }
        
        int res = sIm1;
        // int n = arr.length;
        
        for(int i=1;i<arr.length;i++)
        {
            int si = sIm1 + sum - n * arr[n-i];
            res = Math.max(res, si);
            sIm1 = si;
        }
        return res;
    }	
}
