class Solution 
{
	int sum = 0;
	void fun(TreeNode root)
	{
		if(root==null)
			return;
		fun(root.right);
		sum += root.val;
		root.val = sum;
		fun(root.left);
	}

	public TreeNode convertBST(TreeNode root) 
	{
		fun(root);
		return root;
	}
}
