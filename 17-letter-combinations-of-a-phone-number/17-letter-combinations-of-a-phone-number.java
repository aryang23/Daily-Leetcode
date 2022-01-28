class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0)
            return ans;
        // ans = kpc(digits);
        ans = kpc2(digits, 0);
        return ans;
    }
    
    public List<String> kpc(String str) {
        String[] arr = {".;","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        if(str.length() == 0) {
            ArrayList<String> ba = new ArrayList<>();
            ba.add("");
            return ba;
        }
        
        int num = str.charAt(0) - '0';
        String ls = str.substring(1);
        List<String> smallAns = kpc(ls);
        
        String smallStr = arr[num-1];
        
        List<String> ans = new ArrayList<>();
        
        for(int i=0; i<smallStr.length(); i++) {
            char ch = smallStr.charAt(i);
            for(int j=0; j<smallAns.size(); j++) {
                ans.add(ch + smallAns.get(j));
            }
        }
        return ans;
    }
    
    public List<String> kpc2(String str, int idx) {
        String[] arr = {".;","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        if(idx == str.length()) {
            ArrayList<String> ba = new ArrayList<>();
            ba.add("");
            return ba;
        }
        
        int num = str.charAt(idx) - '0';
        // String ls = str.substring(1);
        List<String> smallAns = kpc2(str, idx+1);
        
        String smallStr = arr[num-1];
        
        List<String> ans = new ArrayList<>();
        
        for(int i=0; i<smallStr.length(); i++) {
            char ch = smallStr.charAt(i);
            for(int j=0; j<smallAns.size(); j++) {
                ans.add(ch + smallAns.get(j));
            }
        }
        return ans;
    }
}