class Solution {
    public boolean checkZeroOnes(String s) {
        int oneMaxx = 0, zeroMaxx = 0;
        int i=0, n = s.length();
        while(i<n)
        {
            int oneCount = 0, zeroCount = 0;
            int num = s.charAt(i)-'0';
            if(num == 1)
            {
                // System.out.println(1);
                oneCount++;
                i++;
                oneMaxx = Math.max(oneMaxx, oneCount);
                if(i==n)
                    break;
                num = s.charAt(i)-'0';
                while(i<n && num==1)
                {
                    oneCount++;
                    i++;
                    if(i==n)
                    break;
                    num = s.charAt(i)-'0';
                }
                oneMaxx = Math.max(oneMaxx, oneCount);
            }
            else
            {
                zeroCount++;
                i++;
                zeroMaxx = Math.max(zeroMaxx, zeroCount);
                if(i==n)
                    break;
                num = s.charAt(i)-'0';
                while(i<n && num==0)
                {
                    zeroCount++;
                    i++;
                    if(i==n)
                    break;
                    num = s.charAt(i)-'0';
                }
                zeroMaxx = Math.max(zeroMaxx, zeroCount);
            }
        }

        if(oneMaxx > zeroMaxx)
            return true;
        else
            return false;
    }
}
