// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 


class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
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
    public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
		    String s = br.readLine();
	    	Node root = buildTree(s);
		    Solution obj = new Solution();
		    int mx = obj.findMax(root);
		    int mn = obj.findMin(root);
		    System.out.println(mx+" "+mn);
		}
	}
}// } Driver Code Ends


//User function Template for Java

/*
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution{
    public static int max(Node node) {
    // write your code here
    int max = node.data;
    
    // for(int i=0; i<node.children.size(); i++) {
    //     max = Math.max(max, max(node.children.get(i)));
    // }
    
    if(node.left != null)
    max = Math.max(max, max(node.left));
    
    if(node.right != null)
    max = Math.max(max, max(node.right));
    
    
    return max;
  }
  
    public static int findMax(Node root){
        //code here
        int ans = max(root);
        return ans;
    }
    
    
     public static int min(Node node) {
         
    // write your code here
    int min = node.data;
    
    // for(int i=0; i<node.children.size(); i++) {
    //     // min = Math.min(min, min(node.children.get(i)));
    // }
    if(node.left != null)
    min = Math.min(min, min(node.left));
    
    if(node.right != null)
    min = Math.min(min, min(node.right));
    
    
    return min;
  }
    public static int findMin(Node root){
        //code here
        return min(root);
    }
}