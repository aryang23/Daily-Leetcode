class Solution {
    public int secondHighest(String s) {
        int max = -1;
        int smax = -1;
        
        for(char c:s.toCharArray())
        {
            int num = c - '0';
            if(num >= 0 && num <= 9)
            {
                if(num > max){
                    smax = max;
                    max = num;
                }
                if(num < max && num > smax) {
                    smax = num;
                }
            }
        }
        
        return smax;
    }
}