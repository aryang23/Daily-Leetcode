class Solution {
    public int maxProduct(String[] words) {
        int[] res = new int[words.length];
        for(int i=0;i<words.length;i++){
            res[i]= getIntValue(words[i]);
        }
        int result=0;
        for(int i=0;i<words.length;i++){
            for(int j=i;j<words.length;j++){
                if((res[i]& res[j])!=0){
                    continue;
                }
                result=Math.max(result,words[i].length()*words[j].length());
            }
        }
        
        return result;
    }
    
    public int getIntValue(String word){
        int res=0;
        for(char c : word.toCharArray()){
            int shift=c-'a';
            res=res | (1<< shift);
        }
        return res;
    }
}
