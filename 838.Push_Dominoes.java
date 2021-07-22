//Brute  Force Soln

class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] lArr = new int[n];
        int[] rArr = new int[n];
        
        for(int i=dominoes.length()-1;i>=0;i--)
        {
            if(dominoes.charAt(i)=='R')
            {
                lArr[i] = -1;
            }
            else if(dominoes.charAt(i)=='L')
            {
                lArr[i] = 0;
            }
            else if(i!=n-1 && lArr[i+1]>=0)
            {
                lArr[i] = lArr[i+1]+1;
            }
            else
            {
                lArr[i] = -1;
            }
        }
        
        for(int i=0;i<n;i++)
        {
            if(dominoes.charAt(i)=='L')
            {
                rArr[i] = -1;
            }
            else if(dominoes.charAt(i)=='R')
            {
                rArr[i] = 0;
            }
            else if(i>0 && rArr[i-1]>=0)
            {
                rArr[i] = rArr[i-1]+1;
            }
            else{
                rArr[i]=-1;
            }
        }
        
        // for(int i=0;i<n;i++)
        // {
        //     System.out.print(rArr[i]+" ");
        //     System.out.println(lArr[i]);
        // }
        
        String ans ="";
        
        for(int i=0;i<n;i++)
        {
            int lElem = lArr[i];
            int rElem = rArr[i];
            if(lElem == rElem)
            {
                ans+=".";
            }
            else if(lElem!=-1 && rElem!=-1)
            {
                if(lElem<rElem)
                ans+="L";
                else
                    ans+="R";
            }
            else
            {
                if(lElem>rElem)
                    ans+="L";
                else
                    ans+="R";
            }
        }
        
        return ans;
        
    }
}
