class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return helper(nums1, nums2) + helper(nums2, nums1); 

    }
    
    public int helper(int[] arr1, int[] arr2) {
        int res = 0;
        int n = arr2.length;
        
        for(long num:arr1) {
            int l=0, r=n-1;
            while(l<r) {
                long val1 = arr2[l];
                long val2 = arr2[r];
                
                if(val1 == val2) {
                    res += val1*val2==num*num?(r-l)*(r-l+1)/2:0;
                    break;
                }
                
                if(num*num == val1*val2) {
                    int c1 = 0;
                    while(l<r && arr2[l] == val1) {
                        c1++;
                        l++;
                    }
                    while(arr2[r] == val2) {
                        res += c1;
                        r--;
                    }
                } else if(val1*val2 > num*num) {
                    while(l<r && arr2[r] == val2) {
                        r--;
                    }
                } else {
                    while(l<r && arr2[l] == val1) {
                        l++;
                    }
                }
            }
            
        }
        return res;
    }
}