class Solution {
    
    int[][] direction = new int[][]{{ 0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public int minimumEffortPath(int[][] heights) {
        
        int m = heights.length, n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {return a[0] - b[0];});
        
        int gap = 0;
        boolean[][] visited = new boolean[m][n];
        pq.add(new int[]{0, 0, 0});
            
        while(!pq.isEmpty()){
            
            int[] arr = pq.poll();
            int x = arr[1], y = arr[2];
            if(visited[x][y] == true) continue;
            visited[x][y] = true;
            gap = Math.max(gap, arr[0]);
            if(x == m - 1 && y == n - 1) break;
            
            for(int[] dir : direction){
                int newX = x + dir[0], newY = y + dir[1];
                if(newX >= 0 && newY >= 0 && newX < m && newY < n && !visited[newX][newY]){
                    int abs_gap = Math.abs(heights[newX][newY] - heights[x][y]);
                    pq.add(new int[]{abs_gap, newX, newY});
                }
                
            }
            
        }
        return gap;
    }
}
