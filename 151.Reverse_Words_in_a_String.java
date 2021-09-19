class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> res = new ArrayList<>();
        
        int i=0;
        while(i<s.length())
        {
            String temp = "";
            char ch = s.charAt(i);
            if(ch==' ')
            {
                i++;
                continue;
            }
            while(ch!=' ' && i<s.length())
            {
                temp += (s.charAt(i)+"");
                i++;
                if(i<s.length())
                ch = s.charAt(i);
            }
            // i--;
            res.add(temp);
        }
        // System.out.println(res+" "+res.size());
        Collections.reverse(res);
        String ans = "";
        for(int j=0;j<res.size();j++)
        {
            ans += res.get(j)+" ";
        }
        ans = ans.trim();
        return ans;
    }
}
