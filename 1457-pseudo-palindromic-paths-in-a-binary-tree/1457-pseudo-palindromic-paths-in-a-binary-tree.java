/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = fun(root, map);
        return ans;
    }
    public int fun(TreeNode root, HashMap<Integer, Integer> map) {
        if(root==null) {
            return 0;
        }
        if(root.left==null && root.right==null) {
            int isSing = 0;
            map.put(root.val, map.getOrDefault(root.val, 0)+1);
            // System.out.println(map.size());
            
            for(int key:map.keySet()) {
                // System.out.println(key+",,,"+map.get(key)+"outside");
                if((map.get(key))%2==1) {
                    // System.out.println(key+",,,"+map.get(key));
                    isSing++;
                }
            }
            Integer val = map.get(root.val);
            val--;
            if(val != 0) {
                map.put(root.val, val);
            } else {
                map.remove(root.val);
            }
            if(isSing > 1) {
                return 0;
            }
            return 1;
        }
        //Root is here
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        int ans = 0;
        ans += fun(root.left, map);
        ans += fun(root.right, map);
        Integer val = map.get(root.val);
        val--;
        if(val != 0) {
            map.put(root.val, val);
        } else {
            map.remove(root.val);
        }
        return ans;
    }
}