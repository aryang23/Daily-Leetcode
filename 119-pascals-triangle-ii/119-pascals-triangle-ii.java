class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        
        long temp = 1;
        int n = rowIndex;
        for(int r=0; r<=n-1; r++) {
            temp = (temp*(n-r)) / (r+1);
            ans.add((int)temp);
        }
        return ans;
    }
}