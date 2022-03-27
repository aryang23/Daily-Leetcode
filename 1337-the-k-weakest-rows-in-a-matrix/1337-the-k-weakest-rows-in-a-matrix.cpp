class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        vector<pair<int,int> > m;
        int n=mat.size();
        for(int i=0;i<n;i++)
        {
            m.push_back(make_pair(countOnes(mat[i]),i));
        }
        int ans=0;
        sort(m.begin(),m.end());
        vector<int> res;
        for(int i=0;i<k;i++)
        {
            res.push_back(m[i].second);
        }
        return res;
    }
    private:
        int countOnes(vector<int> v)
        {
            int ones=0;
            int n=v.size();
            for(int i=0;i<n;i++)
            {
                if(v[i]==1)
                    ones++;
            }
            return ones;
        }
};