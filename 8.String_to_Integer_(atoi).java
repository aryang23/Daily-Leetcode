class Solution {
    public int myAtoi(String s) {
        
        int i=0;
        int n = s.length();
        int ans = 0;
        
        // 1. Empty String
        if(n==0)
            return 0;
        
        //2. Remove spaces
        s = s.trim();
        
        n =  s.length();
        if(n==0)
            return 0;
        
        
        //3. Check if first is char
        if(!Character.isDigit(s.charAt(0)) && s.charAt(0)!='+' && s.charAt(0)!='-')
            return 0;
        
        //4. Get the sign
        boolean isNeg = false;
        if(s.charAt(0)=='+' || s.charAt(0)=='-')
        {
            isNeg=(s.charAt(0)=='-'?true:false);
            i++;
        }
        //5. Getting the number
        for(;i<n;i++)
        {   
            int digit = (s.charAt(i)-'0');
            // System.out.println(digit+"i"+i);
            if(digit<0 || digit>9)
                break;
            
            //VVI Check
            if((Integer.MAX_VALUE-digit)/10<ans)
                return isNeg != true ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            ans = ans * 10 + digit;
        }
        
        if(isNeg==true)
            ans = -ans;
        return ans;
    }
}
