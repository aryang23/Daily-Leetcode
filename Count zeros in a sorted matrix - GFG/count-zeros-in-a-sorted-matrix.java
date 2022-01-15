// { Driver Code Starts
import java.util.*;



class Count_0_In_Sorted_Matrix
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<n; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new GfG().countZeros(arr, n));
		t--;
		}
	}
}// } Driver Code Ends


class GfG
{
    /*you are required to complete this method*/
    int countZeros(int arr[][], int n)
    {
        int count = 0;
        // Your code here
        int i=0, j = n-1;
        while(i<n && j>=0) {
            if(arr[i][j] == 1) {
                j--;
            } else {
                count += (j+1);
                i++;
            }
        }
        return count;
    }
}