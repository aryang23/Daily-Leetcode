class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        for(int i=0;i<words.length;i++)
        {
            String word = words[i];
            boolean isContained = true;
            for(int j=0;j<word.length();j++)
            {
                char ch = word.charAt(j);
                int idx = allowed.indexOf(ch);
                // System.out.println(idx);
                if(idx==-1)
                    isContained = false;
            }
            if(isContained==false)
                ans++;
        }
        return words.length-ans;
    }
}
