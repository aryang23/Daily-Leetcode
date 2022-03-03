class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1, high = 1_000_000_000;
        while (low <= high) {
            int mid = low + (high - low) / 2, count = 0;
            for (int n: nums)   count += (n - 1) / mid;
            if (count <= maxOperations) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
