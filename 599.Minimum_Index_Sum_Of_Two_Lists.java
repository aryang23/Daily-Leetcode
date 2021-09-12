class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = Arrays.asList(list2);
        for(int i=0;i<list1.length;i++)
        {
            map.put(list1[i], i);
        }
        
        int min = Integer.MAX_VALUE;
        List<String> mainAns = new ArrayList<>();
        for(int i=0;i<list2.length;i++)
        {
            Integer val = map.get(list2[i]);
            if(val != null && i+val<=min)
            {
                if(i+val<min)
                {
                    mainAns.clear();
                    min = i+val;
                }
                mainAns.add(list2[i]);
            }
        }
        return mainAns.toArray(new String[mainAns.size()]);
    }
}
