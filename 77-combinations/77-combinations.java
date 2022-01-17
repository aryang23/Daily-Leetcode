class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = i+1;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        combineHelper(arr, n, k, res, ans, 0);
        return res;
        
    }
    
    public void combineHelper(int[] arr,int n,int k,List<List<Integer>> res, List<Integer> smallAns,int idx)
    {
        if(k == 0)
        {
            List<Integer> ba = new ArrayList<>(smallAns);
            res.add(ba);
            return;
        }
        
        for(int i=idx;i<arr.length;i++)
        {
            smallAns.add(arr[i]);
            combineHelper(arr, n, k-1, res, smallAns, i+1);
            smallAns.remove(smallAns.size()-1);
        }
    }
    
}