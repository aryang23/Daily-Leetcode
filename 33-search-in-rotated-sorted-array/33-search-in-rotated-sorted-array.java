class Solution {
    public int search(int[] arr, int data) {
        int n = arr.length;
        int lo=0, hi = n-1;
        int indx = -1;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(arr[mid] == data) {
                indx = mid;
                break;
            } else if(arr[mid] < arr[hi]) {
                //Right sorted
                if(arr[mid]<data && data<=arr[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                //Left Sorted
                if(arr[mid]>data && data>=arr[lo]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return indx;
    }
}