class Solution {
    public int threeSumMulti(int[] arr, int target) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        int mod=(int)(1e9+7);
        hm.put(arr[0], 1);
        int ans=0;
        for(int i=1;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if(arr[i]+arr[j]>target) 
                    continue;
                else {
                    int re=target-(arr[i]+arr[j]);
                    if(hm.containsKey(re)) 
                        ans=(ans%mod+hm.get(re)%mod)%mod;
                }
            }
            if(hm.containsKey(arr[i])) 
                hm.put(arr[i], hm.get(arr[i])+1);
            
            else 
                hm.put(arr[i], 1);
        }
        return ans;
    }
}