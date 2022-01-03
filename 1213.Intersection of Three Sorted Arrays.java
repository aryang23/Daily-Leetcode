class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int num:arr1)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int num:arr2)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int num:arr3)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(Integer item:map.keySet())
        {
            if(map.get(item) == 3)
                ans.add(item);
        }
        
        return ans;
    }
}
