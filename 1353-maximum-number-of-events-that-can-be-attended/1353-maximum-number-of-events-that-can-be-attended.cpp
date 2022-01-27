class Solution {
public:
    int maxEvents(vector<vector<int>>& events) {
        int res = 0, day = 1;
        int n = events.size();
        sort(events.begin(), events.end());
        priority_queue<int, vector<int>, greater<int>> pq;
        int i=0;
        
        while(i<n || pq.size()) {
            while(pq.size() && pq.top() < day) {
                pq.pop();
            }
            while(i<n && events[i][0] == day) {
                pq.push(events[i++][1]);
            }
            
            day++;
            if(pq.size()) {
                res++;
                pq.pop();
            }
        }
        return res;
    }
};