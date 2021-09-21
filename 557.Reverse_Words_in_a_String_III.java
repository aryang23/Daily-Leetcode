class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        int i=0, n=s.length();
        while(i<n)
        {
            char ch = s.charAt(i);
            String temp="";
            while(i<n && ch!=' ')
            {
                temp += ch+"";
                i++;
                if(i>=n)
                    break;
                ch = s.charAt(i);
            }
            i++;
            list.add(temp);
            temp = "";
        }
        // System.out.println(list);
        String ans = "";
        for(int j=0;j<list.size();j++)
        {
            String str = list.get(j);
            String reverse = new StringBuilder(str).reverse().toString();
            ans += reverse+" ";
        }
        ans = ans.trim();
        return ans;
    }
}
