class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++)
        {
            min = Math.min(min, arr[i+1]-arr[i]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<arr.length-1;i++)
        {
            if((arr[i+1]-arr[i]) == min)
            {
                List<Integer> sa = new ArrayList<>();
                sa.add(arr[i]);
                sa.add(arr[i+1]);
                ans.add(sa);
            }
        }
        return ans;
    }
}
