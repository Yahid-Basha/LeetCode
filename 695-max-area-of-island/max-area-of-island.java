class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        int area = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    count++;
                    area = Math.max(dfs(visited, grid, i, j), area);
                }
            }
        }
        return area;
    }
    int dfs(boolean[][] visited, int[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]) return 0;
        visited[r][c] = true;

        return 1+dfs(visited, grid, r-1, c)+dfs(visited, grid, r, c-1)+dfs(visited, grid, r+1, c)+dfs(visited, grid, r, c+1);
    
    }
}