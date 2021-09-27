class Solution {
    public int numUniqueEmails(String[] emails) {
        int n = emails.length;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        
        //2 Parts are there, 1 is LN, 2 is DN
        int ans = 0;
        HashSet<String> s = new HashSet<>();
        for(String str:emails)
        {
            // String ln="", dn="";
            StringBuilder ln = new StringBuilder();
            StringBuilder dn = new StringBuilder();
            int j=0;
            while(str.charAt(j)!='@')
            {
                ln.append(str.charAt(j));
                j++;
            }
            j++;
            // System.out.println(j+","+n);
            while(j<str.length())
            {
                dn.append(str.charAt(j));
                j++;
            }
            
            String lnStr = ln.toString();
            lnStr = formatting(lnStr);
            // System.out.println(lnStr);
            // System.out.println(dn.toString());
            String out = lnStr+"@"+dn.toString();
            // System.out.println("OUT"+out);
            s.add(out);
        }
        return s.size();
    }
    private String formatting(String s)
    {
        String out="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='.')
                i++;
            if(s.charAt(i)=='+')
                return out;
            else
                out+=s.charAt(i);
        }
        return out;
    }
}
