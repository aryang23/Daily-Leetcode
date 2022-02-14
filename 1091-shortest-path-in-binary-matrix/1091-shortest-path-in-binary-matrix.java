class Solution {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        final int M = grid.length, N = grid[0].length;
        if (grid[0][0] == 1 || grid[M-1][N-1] == 1) return -1;
        if (M == 1 && N == 1) return 1;
        int depth = 1;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0});
        grid[0][0] = -1;
        while (!que.isEmpty()) {
            depth++;
            int size = que.size();
            for (int k = 0; k < size; k++) {
                int[] cell = que.poll();
                for (int[] dir : DIRS) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    if (outOfBound(grid, x, y) || grid[x][y] != 0) continue;
                    if (x == M-1 && y == N-1) return depth;
                    que.add(new int[]{x, y});
                    grid[x][y] = -1;
                }
            }
        }
        return -1;
    }
    
    private static boolean outOfBound(int[][] grid, int x, int y) {
        return x < 0 || y < 0 || x >= grid.length || y >= grid[0].length;
    }
}
