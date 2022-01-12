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
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        if(root==NULL)
            root=new TreeNode(val);
        else
        {
            if(root->val > val)
            {
                root->left=insertIntoBST(root->left,val);
            }
            else
                root->right=insertIntoBST(root->right,val);
        }
        return root;
    }
//     TreeNode* search(TreeNode* root,int val)
//     {
//         //Base Case or Edge Case
//         if(root==NULL)
//             return NULL;
        
//         if(root.val==val)
//             return root;
        
//         if(root.val>val)
//             return search(root.left,val);
//         if(root.val<val)
//         {
//             return search(root.right,val);
//         }
//     }
};