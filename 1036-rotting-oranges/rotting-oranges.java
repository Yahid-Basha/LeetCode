class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> que = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) que.offer(new int[] {i, j});
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while(!que.isEmpty() && fresh > 0){
            int size = que.size();
            for(int i = 0; i < size; i++){
                int[] curr = que.poll();
                int row = curr[0];
                int col = curr[1];

                for(int[] dir: directions){
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1){
                        grid[r][c] = 2;
                        fresh--;
                        que.offer(new int[]{r, c});
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}