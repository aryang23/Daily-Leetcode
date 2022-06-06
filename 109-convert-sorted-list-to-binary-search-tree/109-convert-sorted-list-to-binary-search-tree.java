/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        int sz = getSize(head);
        int[] arr = new int[sz];
        
        ListNode temp = head;
        int k = 0;
        while(temp != null) {
            arr[k++] = temp.val;
            temp = temp.next;
        }
        return buildTreeHelper(arr, 0, sz-1);
    }
    
    public int getSize(ListNode head) {
        int sz = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }
        return sz;
    }
    
    public TreeNode buildTreeHelper(int[] nums, int lo, int hi) {
        if(lo > hi) {
            return null;
        }
        int mid = (lo+hi)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTreeHelper(nums, lo, mid-1);
        node.right = buildTreeHelper(nums, mid+1, hi);
        return node;
    }
    
    public ListNode getNodeAt(ListNode head, int k) {
        ListNode temp = head;
        while(k-- > 0) {
            temp = temp.next;
        }
        return temp;
    }
}