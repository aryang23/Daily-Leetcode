class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n<3)
            return false;
        int pivotPt = 0;
        
        for(int i=0; i<n-1; i++) {
            if(arr[i] >= arr[i+1]) {
                pivotPt = i;
                break;
            }
        }
        if(pivotPt == 0 || pivotPt == n-1)
            return false;
        
        
        for(int i=0; i<pivotPt-1; i++) {
            if(arr[i] < arr[i+1]) {
                
            } else {
                return false;
            }
        }
        
        for(int i=pivotPt; i<n-1; i++) {
            if(arr[i] > arr[i+1]) {
                
            } else {
                return false;
            }
        }
        
        return true;
    }
}