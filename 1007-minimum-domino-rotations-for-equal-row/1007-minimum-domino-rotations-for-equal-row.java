class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        return minimumRotations(tops, bottoms);
    }
    
    private int minimumRotations(int[] tops, int[] bottoms) {
        int length = tops.length;
        int dominoSize = 6;
        int[] topFreq = new int[dominoSize];
        int[] bottomFreq = new int[dominoSize];
        int[] commonFreq = new int[dominoSize];
        
        for(int index = 0; index < length; index++) {
            int topValue = tops[index] - 1;
            int bottomValue = bottoms[index] - 1;
            
            if(topValue == bottomValue) {
                commonFreq[topValue]++;
            } else {
                topFreq[topValue]++;
                bottomFreq[bottomValue]++;
            }
        }
        
        for(int index = 0; index < dominoSize; index++) {
            int totalFreq = topFreq[index] + bottomFreq[index] + commonFreq[index];
            
            if(totalFreq == length) {
                return Math.min(topFreq[index], bottomFreq[index]);
            }
        }
        
        return -1;
    }
}