class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        
        int count = 0;
        int arr[] = new int[n];
        
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '|'){
                arr[i] = 1;
                count++;
            }
        }
        
        int[] bars = new int[count];
        
        int k = 0;
        
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '|'){
                bars[k] = i;
                k++;
            }
            
            if(i > 0){
                arr[i] += arr[i - 1];
            }
        }
        
        int out[] = new int[queries.length];
        
        for(int i = 0; i< out.length; i++){
            
            int st = ceil(bars, queries[i][0]);
            int ed = floor(bars, queries[i][1]);
            
            if(st == -1 || ed == -1){
                out[i] = 0;
                continue;
            }
            
            int res = ed - st - 1 - (arr[ed] - arr[st] - 1);
            
            if(res < 0) out[i] = 0;
            else out[i] = res;
        }
        
        return out;
    }
    
    static int floor(int[] arr, int target){
        int st = 0;
        int ed = arr.length - 1;
        int res = -1;
        while(st <= ed){
            int mid = st + (ed - st)/2;
            
            if(arr[mid] == target){
                return target;
            }
            
            if(arr[mid] < target){
                res = arr[mid];
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        
        return res;
    }
    
    static int ceil(int[] arr, int target){
        int st = 0;
        int ed = arr.length - 1;
        int res = -1;
        
        while(st <= ed){
            int mid = st + (ed - st)/2;
            
            if(arr[mid] == target){
                return target;
            }
            
            if(target < arr[mid]){
                res = arr[mid];
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        
        return res;
    } 
}