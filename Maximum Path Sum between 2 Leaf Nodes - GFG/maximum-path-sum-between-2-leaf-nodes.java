// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution ob = new Solution();
            System.out.println(ob.maxPathSum(root));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/* class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution
{
    public static class Pair {
      int n2l;
      int l2l;
      
      Pair() {
          
      }
      Pair(int n2l, int l2l) {
          this.n2l = n2l;
          this.l2l = l2l;
      }
  }
  
    int maxPathSum(Node root)
    { 
        Pair rp = helper(root);
    
    if(root.left==null && root.right!=null || root.left!=null && root.right==null) {
        return Math.max(rp.l2l, rp.n2l);
    }
    return rp.l2l;
    } 
    
    public static Pair helper(Node node) {
      if(node == null) {
          return new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
      }
      if(node.left == null && node.right==null)
       {
           return new Pair(node.data, Integer.MIN_VALUE); 
       }
      Pair lp = helper(node.left);
      Pair rp = helper(node.right);
      
      int n2l = max(lp.n2l, rp.n2l) + node.data;
      int l2l = max(lp.l2l, rp.l2l);
      
      if(node.left != null && node.right != null) {
          l2l = Math.max(l2l, lp.n2l + node.data + rp.n2l);
      }
      
      return new Pair(n2l, l2l);
  }
  
      public static int max(int... arr) {
          int max = arr[0];
          
          for(int ele : arr) {
              if(ele > max) {
                  max = ele;
              }
          }
          return max;
      }
}