class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if(n==1)
            return true;
        
        boolean isCapital = false, isLower = false;
        char zw = word.charAt(0), ow = word.charAt(1);
        if(zw >= 'A' && zw <= 'Z') {
            if(ow>='A' && ow <= 'Z')
                isCapital = true;
            else
                isLower = true;
        }
        if(isCapital == false) {
            isLower = true;
        }
        if(isCapital == true) {
            for(char ch : word.toCharArray()) {
                if(ch >= 'A' && ch<='Z')
                {
                    //Do Nothing
                }
                else
                    return false;
            }
        } else if(isLower == true) {
            for(int i=1;i<n;i++) {
                char ch = word.charAt(i);
                if(ch >= 'a' && ch<='z') {
                    //Do Nothing
                } else {
                    return false;
                }
            }  
        }
        
        return true;
    }
}