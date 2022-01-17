class Solution {
    public String largestNumber(int[] arr) {
        int n = arr.length;
    String[] starr = new String[n];
    for(int i=0;i<n;i++) {
        starr[i] = "" + arr[i];
    }
    
    Arrays.sort(starr, (a,b) -> {
        long d1 = Long.parseLong(a+b);
        long d2 = Long.parseLong(b+a);
        
        if(d2 > d1)
            return -1;
        else if(d1 > d2)
            return 1;
        else
            return 0;
    });
    
    StringBuilder res = new StringBuilder();
    
    for(int i=n-1;i>=0;i--) {
        res.append(starr[i]);
    }
    String ans = res.toString();
    return ans.charAt(0) == '0' ? "0" : ans;
    }
}