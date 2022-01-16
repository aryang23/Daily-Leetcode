class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        //3 Cases
        int l=-1,n=seats.size(),maxDist=0;
        for(int i=0;i<n;i++)
        {
            if(seats[i]==1)
            {
                if(l==-1)
                {
                    maxDist=i;
                }
                else
                {
                    maxDist=max(maxDist,(i-l)/2);
                }
                l=i;
                
            }
        }
        if(seats[n-1]==0)
            maxDist=max(maxDist,n-l-1);
        return maxDist;
    }
};