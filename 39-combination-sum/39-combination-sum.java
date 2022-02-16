class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        
        combinationSumHelper(candidates, target, smallAns, 0, res);
        return res;
        
    }
    
    public void combinationSumHelper(int[] candidates, int target, 
                                     List<Integer> smallAns,int idx, List<List<Integer>> res)
    {
        if(target == 0)
        {
            List<Integer> ba = new ArrayList<>(smallAns);
            res.add(ba);
            return;
        }
        
        for(int i=idx;i<candidates.length;i++)
        {
            if(target - candidates[i] >=0)
            {
                smallAns.add(candidates[i]);
                combinationSumHelper(candidates, target-candidates[i], smallAns, i, res);
                smallAns.remove(smallAns.size()-1);
            }
                
        }
    }
        
        
}