class Solution {
    public String makeFancyString(String s) {
        int i=0;
        int n = s.length();
        if(n==1 || n==2)
            return s;
        StringBuilder sb = new StringBuilder();
        while(i<n)
        {
            if(i+2<n && s.charAt(i)==s.charAt(i+1) && s.charAt(i+1)==s.charAt(i+2))
            {
                i++;
                continue;
            }
            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
