class Solution {
    void helper(int n , int leftCnt , int rightCnt , string curr , vector<string>& ans){
        
        //base case
        if(leftCnt == n and rightCnt == n){
            ans.push_back(curr);
            return;
        }
        
        //add opening bracket
        if(leftCnt < n) helper(n,leftCnt+1,rightCnt,curr+"(" , ans);
        
        //add closing bracket
        if(rightCnt < leftCnt) helper(n,leftCnt,rightCnt+1,curr+")" , ans);
    }
public:
    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        helper(n,0,0,"",ans);
        
        return ans;
    }
};