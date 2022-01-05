class Solution {
    public int maxDistance(int[] colors) {
        int size = colors.length;
        
        if(colors[0] != colors[size - 1])
            return size - 1;
        
        int maxDistLeft = Integer.MIN_VALUE, maxDistRight = Integer.MIN_VALUE;
        
        for(int i=1;i<size;i++)
        {
            if(colors[i] != colors[0])
                maxDistLeft = Math.max(maxDistLeft, i);
        }
        
        for(int i=0;i<size-1;i++)
        {
            if(colors[i] != colors[size-1])
                maxDistRight = Math.max(maxDistRight, size - i - 1);
        }
        
        return Math.max(maxDistLeft, maxDistRight);
    }
}
