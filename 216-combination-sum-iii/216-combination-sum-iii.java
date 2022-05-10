class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = new int[9];
        for(int i=0;i<9;i++)
        {
            arr[i]=i+1;
        }
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new  ArrayList<>();
        combinationSum3Helper(res, path, arr, n, k, 0);
        return res;
        
    }
    
    public void combinationSum3Helper(List<List<Integer>> res, List<Integer> smallAns, int[] arr,int n, int k,int idx)
    {
        if(n==0)
        {
            if(smallAns.size()==k)
            {
                List<Integer> ba = new ArrayList<>(smallAns);
                res.add(ba);
            }
        }
        
        for(int i=idx;i<arr.length;i++)
        {
            if(n-arr[i]>=0)
            {
                smallAns.add(arr[i]);
                combinationSum3Helper(res, smallAns, arr, n-arr[i], k, i+1);
                smallAns.remove(smallAns.size()-1);
            }
        }
    }
}