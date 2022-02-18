class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int val:arr) {
            int rem = val%k;
            
            if(rem<0) {
                rem += k;
            }
            
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        
        for(int rem : map.keySet()) {
            if(rem==0 || (k%2==0 && rem==k/2)) {
                int f = map.get(rem);
                if(f%2==1)
                    return false;
                continue;
            }
            int f1 = map.get(rem);
            int f2 = map.getOrDefault(k-rem, -1);
            
            if(f2==-1 || f1!= f2) {
                return false;
            }
        }
        return true;
    }
}