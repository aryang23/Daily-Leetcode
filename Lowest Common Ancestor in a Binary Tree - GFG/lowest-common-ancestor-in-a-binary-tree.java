// { Driver Code Starts
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String input[] = br.readLine().trim().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution g = new Solution();
                Node k = g.lca(root,a,b);
    			System.out.println(k.data);
    	        
	        }
	}
}
// } Driver Code Ends


/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Solution
{
    //Function to return the lowest common ancestor in a Binary Tree
    
    public static ArrayList<Node> nodeToRootPath(Node node, int data) {
    if (node.data == data) {
      ArrayList<Node> path = new ArrayList<>();
      path.add(node);
      return path;
    }
    if(node.left != null) {
        ArrayList<Node> ptc = nodeToRootPath(node.left, data);
          if (ptc.size() > 0) {
            ptc.add(node);
            return ptc;
          }
    }
    
    if(node.right != null) {
       ArrayList<Node> ptc = nodeToRootPath(node.right, data);
      if (ptc.size() > 0) {
        ptc.add(node);
        return ptc;
      }
    }
      
    
    // for (Node child : node.children) {
    //   ArrayList<Integer> ptc = nodeToRootPath(child, data);
    //   if (ptc.size() > 0) {
    //     ptc.add(node.data);
    //     return ptc;
    //   }
    // }

    return new ArrayList<>();
  }
  
	Node lca(Node root, int d1,int d2)
	{
		// Your code here
		ArrayList<Node> arr1 = nodeToRootPath(root, d1);
		
        ArrayList<Node> arr2 = nodeToRootPath(root, d2);
        if(arr1.size()==0 || arr2.size()==0)
        return new Node(-1);
        
        Collections.reverse(arr1);
        Collections.reverse(arr2);
        
        int ans = 0;
        
        
        Node nAns = null;
        int sz = Math.min(arr1.size(), arr2.size());
        for(int i=0; i<sz; i++) {
            if(arr1.get(i).data == arr2.get(i).data) {
                nAns = arr1.get(i);
            }
        }
        return nAns==null?new Node(-1):nAns;
	}
}

