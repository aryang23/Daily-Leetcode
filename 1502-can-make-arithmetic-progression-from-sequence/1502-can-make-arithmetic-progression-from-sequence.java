class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        
        if ( arr.length <= 2 ) return true;
        
        Arrays.sort(arr);
        int index = 0;
        int comp = arr[index] - arr[index+1]; 
        
        for ( int i = 1; i < arr.length - 1; i++ ){
            
            if( arr[i] - arr[i+1] != comp ){
                
                return false;
                
            }
            
        }
        
        return true;
    }
}