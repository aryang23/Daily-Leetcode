class Solution {
    public boolean backspaceCompare(String s, String t) {
        String sBuild = build(s);
        String tBuild = build(t);
        
        return sBuild.equals(tBuild);
    }
    public String build(String s)
    {
        Stack<Character> ans = new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c!='#')
                ans.push(c);
            else if(!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}
