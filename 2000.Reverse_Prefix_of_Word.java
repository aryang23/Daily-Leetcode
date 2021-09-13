class Solution {
    public String reversePrefix(String word, char ch) {
        Integer si = word.indexOf(ch);
        if(si==null || word.length()==1)
            return word;
        String s1 = word.substring(0, si+1);
        String s2 = word.substring(si+1);
        // s1.reverse();
        String reverse = new StringBuilder(s1).reverse().toString();
        StringBuilder sb = new StringBuilder();
        sb.append(reverse);
        sb.append(s2);
        String s3 = sb.toString();
        return s3;
    }
}
