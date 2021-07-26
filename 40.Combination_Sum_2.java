class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        
        combinationSumHelper2(candidates, target, smallAns, 0, res);
        return res;
    }
    
    public void combinationSumHelper2(int[] candidates, int target, 
                                     List<Integer> smallAns,int idx, List<List<Integer>> res)
    {
        if(target == 0)
        {
            List<Integer> ba = new ArrayList<>(smallAns);
            res.add(ba);
            return;
        }
        
        int prev =-1;
        for(int i=idx;i<candidates.length;i++)
        {
            // if(i>=1 && candidates[idx]==candidates[i-1])
            //     continue;
            
            if(prev!=candidates[i] && target - candidates[i] >=0)
            {
                smallAns.add(candidates[i]);
                combinationSumHelper2(candidates, target - candidates[i], smallAns, i + 1, res);
                smallAns.remove(smallAns.size()-1);
                prev=candidates[i];
            }
        }
    }
    
    
}
