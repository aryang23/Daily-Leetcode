class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int lo = 0, hi = n-1;
        
        while(lo<=hi)
        {
            int mid = (lo+hi)/2;
            
            if(arr[mid]==target)
                return mid;
            else if(arr[lo]<=arr[mid])
            {
                //Low to Mid part is sorted
                if(target>=arr[lo] && arr[mid]>target)
                {
                    hi = mid-1;
                }
                else
                    lo = mid+1;
            }
            else if(arr[mid]<=arr[hi])
            {
                //Mid to High Part is sorted
                if(target>arr[mid] && target<=arr[hi])
                    lo = mid+1;
                else
                    hi = mid-1;
            }
        }
        return -1;
        
    }
}
