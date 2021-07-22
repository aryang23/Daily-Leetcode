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



//22ms solution
class Solution {
    public String pushDominoes(String dominoes) {
        
        int n = dominoes.length();
        int[] left = new int[n];
        int nearestLeftIndex = -1;
        for(int i=n-1;i>=0;i--)
        {
            char c = dominoes.charAt(i);
            if(c=='L')
            {
                nearestLeftIndex = i;
            }
            else if(c=='R')
            {
                nearestLeftIndex = -1;
            }
            left[i] = nearestLeftIndex;
        }
        
        int[] right = new int[n];
        int nearestRightIndex = -1;
        for(int i=0;i<n;i++)
        {
            char c = dominoes.charAt(i);
            if(c=='L')
            {
                nearestRightIndex = -1;
            }
            else if(c=='R')
            {
                nearestRightIndex = i;
            }
            right[i] = nearestRightIndex;
        }
        
        char[] ans = new char[n];
        for(int i=0;i<n;i++)
        {
            if(dominoes.charAt(i)=='.')
            {
                int nearestLeft = left[i];
                int nearestRight = right[i];
                
                int leftDiff = nearestLeft == -1 ? Integer.MAX_VALUE: Math.abs(nearestLeft - i);
                int rightDiff = nearestRight == -1 ?
                    Integer.MAX_VALUE : Math.abs(nearestRight - i);
                if(leftDiff == rightDiff)
                {
                    ans[i]='.';
                }
                else if(leftDiff < rightDiff)
                {
                    ans[i]='L';
                }
                else if(leftDiff > rightDiff)
                {
                    ans[i] = 'R';
                }
            }
            else
            {
                ans[i] =  dominoes.charAt(i);
            }
        }
        return new String(ans);
    }
}
