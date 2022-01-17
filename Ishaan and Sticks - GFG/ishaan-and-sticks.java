// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Complete obj = new Complete();
		    ArrayList<Integer> ans;
		    ans = obj.square(arr, sizeOfArray);
		    for(int i: ans)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    // Function for finding maximum and value pair
    public static ArrayList<Integer> square (int arr[], int n) {
        //Complete the function
              HashMap<Integer, Integer> map = new HashMap<>();
      int maxArea = Integer.MIN_VALUE;
      int count = 0;
      for(int val:arr)
        map.put(val, map.getOrDefault(val, 0) + 1);
        
      for(int side:map.keySet()) {
          int val = map.get(side);
          int currArea = side*side;
          if(currArea > maxArea) {
              if(val >= 4) {
                  maxArea = currArea;
                  count = val / 4;
              }
          }
      }
      
      ArrayList<Integer> ans = new ArrayList<>();
      if(maxArea == Integer.MIN_VALUE) {
          ans.add(-1);
          return ans;
      }
      ans.add(maxArea);
      ans.add(count);
      return ans;
    }
    
    
}


