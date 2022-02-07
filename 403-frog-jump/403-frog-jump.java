class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    for(int stone:stones) {
        map.put(stone, new HashSet<>());
    }
    map.get(stones[0]).add(1);
    
    for(int i=0; i<stones.length; i++) {
        int currStone = stones[i];
        for(int jump:map.get(currStone)) {
            int nextSpot = currStone + jump;
            if(nextSpot == stones[stones.length-1])
            return true;
            
            if(map.containsKey(nextSpot)) {
                if(jump-1 >= 0) 
                map.get(nextSpot).add(jump-1);
                
                map.get(nextSpot).add(jump);
                map.get(nextSpot).add(jump+1);
            }
        }
    }
    return false;
  
    }
}