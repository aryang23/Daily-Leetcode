class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        
        List<Integer> v = new ArrayList<>();
        
        int count = 1;
        for(int i=1;i<arr.length;i++) {
            if(arr[i] == arr[i-1]) {
                count += 1;
            } else {
                v.add(count);
                count = 1;
            }
        }
        v.add(count);
        Collections.sort(v);
        int i=0;
        int sum=0;
        int cnt = v.size();
        while(i<v.size() && sum + v.get(i) <= k) {
            sum += v.get(i);
            i+=1;
            cnt-=1;
        }
        
        return cnt;
    }
}