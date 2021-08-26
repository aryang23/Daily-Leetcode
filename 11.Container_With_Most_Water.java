class Solution {
    public int maxArea(int[] heights) {
        
        int n = heights.length;
        int i = 0, j = n-1;
        
        int water = 0, width = 0, height = 0;;
        while(i<j)
        {
            height = Math.min(heights[i], heights[j]);
            width = j-i;
            
            int currWater = height*width;
            water = Math.max(water, currWater);
            if(heights[i]<heights[j])
                i++;
            else
                j--;
            }
        return water;
        
    }
}
