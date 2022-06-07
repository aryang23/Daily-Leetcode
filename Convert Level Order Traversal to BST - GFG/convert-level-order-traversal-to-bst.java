// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class GFG 
{
    static class Pair {
        int lr;
        int rr;
        Node parent;
        
        Pair() {
            
        }
        
        Pair(int lr, int rr, Node parent) {
            this.lr = lr;
            this.rr = rr;
            this.parent = parent;
        }
    }
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr)
    {
        //Write your code here
        Node root = null;
        ArrayDeque<Pair> q = new ArrayDeque<>();
        
        Pair bp = new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, null);
        q.add(bp);
        
        int idx = 0;
        
        while(idx < arr.length) {
            Pair rem = q.remove();
            
            if(arr[idx] < rem.lr || arr[idx] > rem.rr) {
                //Out of Range
                continue;
            } else {
                Node child = new Node(arr[idx]);
                idx++;
                
                if(rem.parent == null) {
                    root = child;
                } else if(rem.parent.data > child.data) {
                    rem.parent.left = child;
                } else {
                    rem.parent.right = child;
                }
                
                //Left Pair
                q.add(new Pair(rem.lr,child.data,child));
                //Right Pair
                q.add(new Pair(child.data, rem.rr, child));
            }
        }
        return root;
    }
}