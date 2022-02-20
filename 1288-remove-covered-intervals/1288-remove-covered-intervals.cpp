class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        vector<int> curr;
        curr.push_back(-1);
        curr.push_back(-1);
        int result = 0;
        for(auto in:intervals) {
            if(in[0]>curr[0] && in[1]>curr[1]) {
                curr[0] = in[0];
                result++;
            }
            curr[1] = max(curr[1], in[1]);
        }
        return result;
    }
};