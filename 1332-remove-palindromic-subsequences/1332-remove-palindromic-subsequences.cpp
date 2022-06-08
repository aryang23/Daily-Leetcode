class Solution {
public:
    int removePalindromeSub(string s) {
        if(s.size()==0)
            return 0;
        int st=0,e=s.length()-1;
        while(st<e)
        {
            if(s[st]!=s[e])
            {
                return 2;
            }
            st++;
            e--;
        }
        return 1;
    }
};