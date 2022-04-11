class Solution {
    public List<List<Integer>> shiftGrid(int[][] arr, int k) {
        int m = arr.length;
        int n = arr[0].length;
        int total = m*n;
        k = k%total;
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i<m; i++){
            List<Integer> al = new ArrayList<>();
            ans.add(al);
            for(int j=0; j<n; j++){
                int actual_index = (i*n)+j;
                int index = (actual_index-k+total)%total;
                
                al.add(arr[index/n][index%n]);
            }
        }
        
        return ans;
    }
}