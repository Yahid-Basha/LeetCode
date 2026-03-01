class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        if(freshCount == 0) return 0;
        return bfs(grid, queue, freshCount);
    }
        int bfs(int[][] grid, Queue<int[]> queue, int freshCount){
            int[][] dirs = {{0, 1},{0, -1}, {1, 0}, {-1, 0}};
            int time = 0;
            while(!queue.isEmpty()){
                boolean rotted = false;
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int[] curr = queue.poll();
                    for(int[] dir : dirs){
                        int r = curr[0]+dir[0], c = curr[1]+dir[1];
                        if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1){
                            queue.offer(new int[]{r, c});
                            grid[r][c] = 2;
                            freshCount--;
                            rotted = true;
                        }
                    }
                }
                if(rotted) time++;
            }
            return freshCount > 0 ? -1 : time;
        }
}