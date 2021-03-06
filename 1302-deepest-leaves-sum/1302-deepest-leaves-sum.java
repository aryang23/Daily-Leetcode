class Solution {

    int depth;
    int sum;

    public int deepestLeavesSum(TreeNode root) {
        depth=0; sum=0;
        dfs(root,1);
        return sum;
    }

    public void dfs(TreeNode root, int level){
        if(root == null) return;
        if(level>depth){
            depth=level;
            sum=0;
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
        if(depth==level){
            sum+=root.val;
        }
    }
}