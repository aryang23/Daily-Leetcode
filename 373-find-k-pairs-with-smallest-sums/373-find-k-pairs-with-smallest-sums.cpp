class Solution {
public:
    struct cmp {
        bool operator()(pair<int, int> const& p1, pair<int, int> const& p2) {
            return p1.first + p1.second > p2.first+p2.second;
        }
    };
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        priority_queue<pair<int, int>, vector<pair<int, int>>,cmp> pq;
        for(int i=0; i<min((int)nums1.size(), k); i++) {
            for(int j=0; j<min((int)nums2.size(), k); j++) {
                pq.push({nums1[i], nums2[j]});
            }
        }
        
        vector<vector<int>> ans;
        while(k>0 && !pq.empty()) {
            pair<int, int> t = pq.top();
            ans.push_back({t.first, t.second});
            pq.pop();
            k--;
        }
        return ans;
    }
};