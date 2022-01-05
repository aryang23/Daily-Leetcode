class Solution {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> distances = new HashMap<>();
        int ans = 0;
        for(int i=0;i<points.length;i++)
        {
            for(int j=0;j<points.length;j++)
            {
                if(i==j)
                    continue;
                int distance = ((points[i][0] - points[j][0]) * (points[i][0]-points[j][0])) + ((points[i][1] - points[j][1]) * (points[i][1] - points[j][1]));
                distances.put(distance, distances.getOrDefault(distance, 0) + 1);
            }
            
            for(Integer distance:distances.values())
            {
                ans += distance * (distance - 1);
            }
            distances.clear();
        }
        return ans;
    }
}
