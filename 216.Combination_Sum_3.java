class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = new int[9];
        for(int i=0;i<9;i++)
        {
            arr[i] = i+1;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new  ArrayList<>();
        
        combinationSum3Helper(arr, k, n, res, path, 0);
        return res;
    }
    
    public void combinationSum3Helper(int[] arr,int k,int n, List<List<Integer>> res, List<Integer> path,int idx)
    {
        if(n==0)
        {
            if(path.size()==k)
            {
                List<Integer> ba = new ArrayList<>(path);
                res.add(ba);
            }
            return;
        }
        for(int i=idx;i<arr.length;i++)
        {
            if(n-arr[i]>=0)
            {
                path.add(arr[i]);
                combinationSum3Helper(arr, k, n-arr[i], res, path, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
