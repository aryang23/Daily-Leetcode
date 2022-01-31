// { Driver Code Starts
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

class Main {
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
            if (i >= ip.length) break;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
        }
    }
}
// } Driver Code Ends


// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
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
    return new ArrayList<>();
    }
  
    public static int findDist(Node node, int d1, int d2) {
        // Your code here
        ArrayList<Node> arr1 = nodeToRootPath(node,d1);
    ArrayList<Node> arr2 = nodeToRootPath(node,d2);
    //120,80,10 aaya
    
    Collections.reverse(arr1);
    Collections.reverse(arr2);
    
    //10,80,120 krdiya
    //Direct jab tak similar hai, count nikala nd then wo c++ krte rhe, if not match, simply break krdiya  n ans nikaldiya
    int sz = Math.min(arr1.size(),arr2.size());
    int c1 = 0;
    
    for(int i=0; i<sz; i++) {
        if(arr1.get(i) != arr2.get(i))
        break;
        
        c1++;
    }
    
    int ans = arr1.size() + arr2.size() - 2 * c1;
    return ans;
    }
}