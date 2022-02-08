class Solution {
    public int addDigits(int num) {
        int len = String.valueOf(num).length();
        int no = num;
        
        if(len==1)
            return num;
        
        while(len != 1) {
            int ans = 0, n = no;
            while(n>0) {
                int ld = n%10;
                ans += ld;
                n = n / 10;
            }
            len = String.valueOf(ans).length();
            no = ans;
            if(len==1)
                return ans;
        }
        return 0;
    }
}