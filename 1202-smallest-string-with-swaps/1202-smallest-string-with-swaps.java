class Solution {
    int[] parent;
    int[] rank;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0; i < n;i++){//initialization
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(List<Integer> l : pairs){//as if pairs are 0,1 and then 1,3 then it means we can also swap 0,3 so they are transistive in nature so group them using DSU
            union(l.get(0) , l.get(1));//grouping the indices at which we can swap
        }
        
        HashMap<Integer,PriorityQueue<Character>> map = new HashMap<>();//parent->available swaps
        //for each char we will have a priority queue in front of it with available char swap as lexogr
        for(int i = 0; i < n; i++){
            int parent = find(i);
            PriorityQueue<Character> temp = new PriorityQueue<>();
            if(map.containsKey(parent)){
                temp = map.get(parent);
            }
            temp.add(s.charAt(i));
            map.put(parent, temp);
        }
        
        char[] ans = s.toCharArray();
        for(int i = 0 ; i < n;i++){
            ans[i] = map.get(find(i)).poll();//first find parent for this i then pop the first small char
        }
        return new String(ans);
    }
    
     private int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
    
    private void union(int a , int b){
        a = find(a);
        b = find(b);
        if(a != b){
            if(rank[a] > rank[b]){
                parent[b] = a;
            }else if(rank[b] > rank[a]){
                parent[a] = b;
            }else{
                parent[b] = a;
                rank[a]++;
            }
        }
    }
}