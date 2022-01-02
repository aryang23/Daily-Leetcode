class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans = 0;
        for(String sentence:sentences)
        {
            String[] parts = sentence.split(" ");
            ans = Math.max(ans, parts.length);
        }
        return ans;
    }
}
