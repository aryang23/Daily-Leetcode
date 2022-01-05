/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        int bad = -1;
        while(lo<=hi)
        {
            int mid = lo + (hi - lo) / 2;
            if(isBadVersion(mid))
            {
                bad = mid;
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }
        return bad;
    }
}
