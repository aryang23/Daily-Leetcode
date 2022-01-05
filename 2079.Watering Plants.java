class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int take = capacity;
        int n = plants.length;
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            if(plants[i] > take)
            {
                ans += i;
                ans += i + 1;
                take = capacity;
                take -= plants[i];
            }
            else
            {
                ans++;
                take -= plants[i];
            }
        }
        return ans;
    }
}
