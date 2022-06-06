// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    HashMap<Integer, Integer> map;
    Node buildTree(int inorder[], int level[])
    {
        //your code here
        map = new HashMap<>();
        //Storing Each Elem vs idx in Inorder
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTreeHelper(inorder, level, 0, inorder.length-1);
    }
    
    Node buildTreeHelper(int[] inorder, int[] level, int is, int ie) {
        if(is > ie) {
            return null;
        }
        Node node = new Node(level[0]);
        int idx = map.get(node.data);
        int colse = idx - is;
        int corse = ie - idx;
        
        int[] llo = new int[colse];
        int[] rlo = new int[corse];
        
        segregateLevelOrder(llo, rlo, level, idx);
        
        node.left = buildTreeHelper(inorder, llo, is, idx-1);
        node.right = buildTreeHelper(inorder, rlo, idx+1, ie);
        return node;
    }
    
    void segregateLevelOrder(int[] llo, int[] rlo, int[] level, int idx) {
        int j = 0;
        int k = 0;
        
        for(int i=1; i<level.length; i++) {
            if(map.get(level[i]) < idx) {
                //Belongs to Left subtree
                llo[j++] = level[i];
            } else {
                //Belongs to Right Subtree
                rlo[k++] = level[i];
            }
        }
    }
    
   
}


