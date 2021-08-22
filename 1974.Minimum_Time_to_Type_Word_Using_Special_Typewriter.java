class Solution {
    public int minTimeToType(String word) {
        int seconds = word.length();
        char prev = 'a';
        int ptr = 0;
        for(int i=0;i<word.length();i++)
        {
            char curr = word.charAt(i);
            
            int curr_to_prev = Math.abs(curr-prev);
            int prev_to_curr = 26-Math.abs(prev-curr);
            
            seconds += Math.min(curr_to_prev, prev_to_curr);
            prev = curr;
        }
        return seconds;
        
    }
}
