class Solution {
    public int twoCitySchedCost(int[][] costs) {

         Arrays.sort(costs,new ProfitComparator());
         int minCost=0;

         //first N will go to A as profit is maximum to go to A over B,rest N will go to B.
         for(int i=0;i<costs.length;i++){
             if(i<costs.length/2) minCost+=costs[i][0];
             else minCost+=costs[i][1];

         }
        return minCost;
    }

    public class ProfitComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] one,int[] two){
            int profit1=one[1]-one[0];
            int profit2=two[1]-two[0];
            return profit2-profit1; //max will come 1st
    }
}
}