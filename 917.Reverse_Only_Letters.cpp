class Solution {
     public:
     string reverseOnlyLetters(string s) {
        int n = s.length();
        int left = 0, right = n-1;
        while(left<=right)
        {
            char ch1 = s[left];
            char ch2 = s[right];
            // cout<<ch1<<",,"<<ch2<<",,,";
            if(isChar(ch1) && isChar(ch2))
            {
                s[right] = ch1;
                s[left] = ch2;
                left++;
                right--;
            }
            else if(!isChar(ch1))
            {
                left++;
            }
            else
                right--;
            
            // cout<<ch1<<",,"<<ch2<<endl;
        }
         return s;
    }
    bool isChar(char ch)
    {
        if((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90))
            return true;
        return false;
    }
};
