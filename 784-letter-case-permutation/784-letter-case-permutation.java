class Solution {
    List<String> ans = new ArrayList<>();
    public void ok(String s, String curr, int index) {
        if(curr.length() == s.length()) {
            ans.add(curr);
            return;
        }
        char currChar = s.charAt(index);
        if(currChar >= '0' && currChar <= '9')
            ok(s, curr+currChar, index + 1);
        else {
            ok(s, curr+(currChar+"").toUpperCase(), index + 1);
            ok(s, curr + (currChar+"").toLowerCase(), index + 1);
        }
        return;
    }
    public List<String> letterCasePermutation(String s) {
        int n = s.length();
        String curr = "";
        ok(s, curr, 0);
        return ans;
    }
}