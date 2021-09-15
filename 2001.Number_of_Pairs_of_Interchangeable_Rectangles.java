class Solution {
public:
    long long interchangeableRectangles(vector<vector<int>>& rectangles) {
        long long ans = 0;
        int n = rectangles.size();
        map<pair<int, int>, long long> mp;
        for(int i=0;i<n;i++)
        {
            int x = rectangles[i][0];
            int y = rectangles[i][1];
            int g = __gcd(x, y);
            x/=g;
            y/=g;
            mp[{x,y}]++;
        }
        for(auto i:mp)
        {
            ans += (i.second*(i.second-1))/2;
        }
        return ans;
    }
};
//Basically, the idea is to directly store the ratio of 2 elements
//We can't store the ratio, as 0.33333, 0.333333334 will almost be same so we decided to store the x,y pair
//But for that also, 2/3 and 4/6 will be a different pair
//So We decided to divide each number with their GCD and their ratio stored will be 2/3.
//So we stored 2/3 and adding the numbers whenever there is that ratio
//nd in end for pairs, we found them by nC2 i.e. n(n-2)/2
