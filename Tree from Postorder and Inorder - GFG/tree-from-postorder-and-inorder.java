// { Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}
// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        return buildTreeHelper(post, in, 0, n-1, 0, n-1);
    }
    
    public static Node buildTreeHelper(int[] postorder, int[] inorder, int ps, int pe, int is, int ie) {
        
        //Base Case
        if(ps > pe) {
            return null;
        }
        
        //Calculating RootVal, idx
        int rootVal = postorder[pe];
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
        Node leftTree = buildTreeHelper(postorder, inorder, ps, ps+colse-1, is, idx-1);
        Node rightTree = buildTreeHelper(postorder, inorder, ps+colse, pe-1, idx+1, ie);
        
        Node root = new Node(rootVal);
        root.left = leftTree;
        root.right = rightTree;
        
        return root;
    }
}
