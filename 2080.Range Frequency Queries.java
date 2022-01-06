class RangeFreqQuery {
public:
    vector<int> v;
    int n;
    vector<int> freq[10001];
    unordered_map<int, int> mp;
    RangeFreqQuery(vector<int>& arr) {
        v = arr;
        n = v.size();
        mp.clear();
        for(int i=0;i<n;i++)
        {
            freq[arr[i]].clear();
            mp[arr[i]]++;
        }
        
        for(int i=0;i<n;i++)
        {
            freq[arr[i]].push_back(i);
        }
    }
    
    int query(int left, int right, int value) {
        vector<int>& v = freq[value];
        if(mp.find(value) == mp.end())
            return 0;
        int le = lower_bound(v.begin(), v.end(), left) - v.begin();
        int re = upper_bound(v.begin(), v.end(), right) - v.begin();
        return re - le;
    }
};

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery* obj = new RangeFreqQuery(arr);
 * int param_1 = obj->query(left,right,value);
 */
