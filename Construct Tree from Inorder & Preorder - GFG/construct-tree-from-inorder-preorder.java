// { Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends


class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        return buildTreeHelper(preorder, inorder, 0, n-1, 0, n-1);
    }
    public static Node buildTreeHelper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        
        //Base Case
        if(ps > pe) {
            return null;
        }
        
        //Calculating RootVal, idx
        int rootVal = preorder[ps];
        int idx = -1;
         
        for(int i=is; i<=ie; i++) {
            if(inorder[i] == rootVal) {
                idx = i;
                break;
            }
        }
        
        //Calculating Colse: -
        int colse = idx - is;
        
        
        //2 Calls
        Node leftTree = buildTreeHelper(preorder, inorder, ps+1, ps+colse, is, idx-1);
        Node rightTree = buildTreeHelper(preorder, inorder, ps+colse+1, pe, idx+1, ie);
        
        Node root = new Node(rootVal);
        root.left = leftTree;
        root.right = rightTree;
        
        return root;
    }
}
