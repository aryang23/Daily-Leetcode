class Solution {
    public List<String> commonChars2(String[] words) {
        int[] charArr = new int[26];
        for(int i=0;i<words.length;i++)
        {
            String word = words[i];
            for(int j=0;j<word.length();j++)
            {
                char ch = word.charAt(j);
                charArr[ch-'a']++;
            }
        }
        
        List<String> res = new ArrayList<>();
        for(int i=0;i<26;i++)
        {
            // System.out.println(charArr[i]);
            if(charArr[i]>=words.length)
            {
                // res.add(i+"a");
                int temp = charArr[i]/3;
                for(int j=0;j<temp;j++)
                {
                    int num = 97+i;
                    String tempStr = ((char)(num)+"");
                    res.add(tempStr);
                }
            }
        }
        return res;
    }
    
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for(String str:words)
        {
            int[] cnt = new int[26];
            str.chars().forEach(c -> ++cnt[c-'a']);
            for(int i=0;i<26;i++)
            {
                count[i] = Math.min(cnt[i], count[i]);
            }
        }
        
        for(char c='a';c<='z';c++)
        {
            while(count[c-'a']-- > 0)
            {
                ans.add(""+c);
            }
        }
        return ans;
    }
}
