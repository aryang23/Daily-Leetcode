/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int>ans;
    void getAns(TreeNode* root){
        if(root==NULL){
            return;
        }
        getAns(root->left);
        ans.push_back(root->val);
        getAns(root->right);
        
    }
    bool isValidBST(TreeNode* root) {
     getAns(root);
        for(int i=0;i<ans.size()-1;i++){
            if(ans[i]>=ans[i+1]){
                return false;
            }
        }
        return true;
    }
};