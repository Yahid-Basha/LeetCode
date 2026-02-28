class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs( visited, grid, i, j);
                }
            }
        }
        return count;
    }
    void dfs(boolean[][] visited, char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0' || visited[r][c]) return;
        visited[r][c] = true;
        dfs(visited, grid, r-1, c);
        dfs(visited, grid, r, c-1);
        dfs(visited, grid, r+1, c);
        dfs(visited, grid, r, c+1);
    }
}