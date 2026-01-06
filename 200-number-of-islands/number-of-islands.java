class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    sink(grid, i, j, m, n);
                }
            }
        }

        return count;
    }
    public void sink(char[][] grid, int row, int col, int m, int n){
        if(row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == '0') return;
        grid[row][col] = '0';

        sink(grid, row, col-1, m, n);
        sink(grid, row, col+1, m, n);
        sink(grid, row-1, col, m, n);
        sink(grid, row+1, col, m, n);
    }
}