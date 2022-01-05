/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int res = 0;
      int lo = 1;
      int hi = n;
      
      while(lo <= hi)
      {
          int mid = lo + (hi - lo) / 2;
          if(guess(mid) == 0)
          {
              res = mid;
              break;
          }
          else if(guess(mid) > 0)
          {
              lo = mid + 1;
          }
          else
          {
              hi = mid - 1;
          }
      }
    return res;
    }
}
