class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        wordBreak2Helper(s, wordDict, res, "");
        return res;
    }
    
    public void wordBreak2Helper(String str, List<String> wordDict, List<String> res, String ans)
    {
        if(str.length()==0)
        {
            ans = ans.trim();
            res.add(ans);
            return;
        }
        for(int ei=0;ei<str.length();ei++)
        {
            String pword = str.substring(0, ei+1);
            if(wordDict.contains(pword))
                wordBreak2Helper(str.substring(ei+1),wordDict, res,  ans+pword+" ");
        }
    }
    
    
}
