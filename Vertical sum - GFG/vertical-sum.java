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

class GfG {
    
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
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
			
			    ArrayList <Integer> res = g.verticalSum(root);
			    for (Integer num : res) System.out.print (num + " ");
			    System.out.println();
                t--;
            
        }
    }
  
}

// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Solution{
    public static class Pair {
        Node node;
        int x;
        
        Pair() {
            
        }
        
        Pair(Node node, int x) {
            this.node = node;
            this.x = x;
        }
    }
    static int sx;
    static int lx;
    
    public static void helper(Node node, int x) {
        if(node == null) {
            return;
        }
        sx = Math.min(sx, x);
        lx = Math.max(lx, x);
        
        helper(node.left, x-1);
        helper(node.right, x+1);
    }
    
    public ArrayList <Integer> verticalSum(Node root) {
        sx = Integer.MAX_VALUE;
        lx = Integer.MIN_VALUE;
        
        helper(root, 0);
        
        int w = lx - sx + 1;
        
        
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, -sx));
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=0; i<w; i++) {
            ans.add(0);
        }
        
        while(q.size() > 0) {
            //Remove
            Pair rem = q.remove();
            
            //Work
            // ans.get(rem.x).add(rem.node.val);
            int nv = ans.get(rem.x)+ rem.node.data;
            ans.set(rem.x, nv);
            
            //Add Children
            if(rem.node.left != null) {
                q.add(new Pair(rem.node.left, rem.x - 1));
            } 
            if(rem.node.right != null){
                q.add(new Pair(rem.node.right, rem.x + 1));
            }
        }
        return ans;
    }
}
