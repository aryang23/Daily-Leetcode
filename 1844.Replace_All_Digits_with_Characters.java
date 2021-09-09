class Solution {
    public String replaceDigits(String s) {
        char[] charArr = s.toCharArray();
        for(int i=1;i<s.length();i+=2)
        {
            charArr[i] = (char)(charArr[i-1]+charArr[i]-'0');
        }
        return String.valueOf(charArr);
    }
}
