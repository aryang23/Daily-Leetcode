const int m=((int)1e9) + 7;
class Solution {
    // two sum a+b= any power of two 2^(0 to 21)
    //why 21 b/c a=2^20 b=2^20 =>a+b=2^20 +2^20 =2*2^20=2^21
public:
    int countPairs(vector<int>& deliciousness) {
        int ret=0;
        unordered_map<int,int>ump;
        for(int i=0;i<deliciousness.size();i++){
            int power=1;
            for(int j=0;j<=21;j++)
            {
                long diff=power-deliciousness[i];
                if(ump.count(diff))
                {
                    ret+=ump[diff];
                    ret %= m;   
                }   
                power=power*2;
            }
            ump[deliciousness[i]]++;
        }
        return ret;
    }
};
