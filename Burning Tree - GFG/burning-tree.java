// { Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
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
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    static int time; // Maximum Time Taken
    public static int minTime(Node root, int target) 
    {
        time = 0;
        
        ArrayList<Node> n2rp = nodeToRootPath(root, target);
        int t= 0;
        Node bn = null; //Block Node
        
        for(int i=0; i<n2rp.size(); i++) {
            Kdown(n2rp.get(i), t, bn);
            t++;
            bn = n2rp.get(i);
        }
        return time;
    }
    
    public static void Kdown(Node node, int t, Node bn) {
        if(node == null || node == bn) {
            return;
        }
        
        time = Math.max(time, t);
        Kdown(node.left, t+1, bn);
        Kdown(node.right, t+1, bn);
    }
    
    public static ArrayList<Node> nodeToRootPath(Node node, int data) {
        if(node == null) {
            return new ArrayList<>();
        }
        
        if(node.data == data) {
            ArrayList<Node> ba = new ArrayList<>();
            ba.add(node);
            return ba;
        }
        
        ArrayList<Node> la = nodeToRootPath(node.left, data);
        if(la.size() > 0) {
            la.add(node);
            return la;
        }
        
        ArrayList<Node> ra = nodeToRootPath(node.right, data);
        if(ra.size() > 0) {
            ra.add(node);
            return ra;
        }
        
        return new ArrayList<>();
    }
}