class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] keyIndices = new int[26];
        
        //Get the index for each key
        for(int i=0;i<keyboard.length();i++)
        {
            keyIndices[keyboard.charAt(i)-'a'] = i;
        }
        
        int prev = 0;
        int result = 0;
        
        for(char c:word.toCharArray())
        {
            result += Math.abs(prev-keyIndices[c-'a']);
            prev = keyIndices[c-'a'];
        }
        return result;
    }
}
