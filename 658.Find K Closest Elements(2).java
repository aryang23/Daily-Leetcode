class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> res = new LinkedList<>();
        
        int n = arr.length;
        int lo = 0, hi = n - 1;
        int indx = 0;
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            indx = Math.abs(arr[indx]- x) > Math.abs(arr[mid] - x) ? mid : indx;
            if(arr[mid] == x)
                break;
            else if(arr[mid] > x)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        
        lo = indx - 1;
        hi = indx;
        
        while(res.size() < k && lo>=0 && hi<n)
        {
            if(Math.abs(x-arr[lo]) <= Math.abs(arr[hi]-x))
            {
                res.addFirst(arr[lo]);
                lo--;
            }
            else
            {
                res.addLast(arr[hi]);
                hi++;
            }
        }
        
        while(res.size() < k && lo >= 0)
        {
            res.addFirst(arr[lo]);
            lo--;
        }
        
        while(res.size() < k && hi < n)
        {
            res.addLast(arr[hi]);
            hi++;
        }
        
        return res;
    }
}
