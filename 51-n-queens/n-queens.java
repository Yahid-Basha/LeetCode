class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for(char[] row: grid){
            Arrays.fill(row, '.');
        }
        List<List<String>> res = new ArrayList<>();
        dfs(grid, 0, n, res);
        return res;
    }
    void dfs(char[][] grid, int r, int n, List<List<String>> res){
        if(r == n){
            List<String> ans = new ArrayList<>();
            for(char[] arr: grid){
                ans.add(new String(arr));
            }
            res.add(ans);
            return;
        }
        for(int i = 0; i < n; i++){
            if(isValid(grid, r, i, n)){
                grid[r][i] = 'Q';
                dfs(grid, r+1, n, res);
                grid[r][i] = '.';
            }
        }
    }
    boolean isValid(char[][] grid, int r, int c, int n){
        for(int i = 0; i < r; i++){
            if(grid[i][c] == 'Q') return false;
        }
        for(int j = 0; j < c; j++){
            if(grid[r][j] == 'Q') return false;
        }
        int i = r-1, j = c-1;
        while(j >= 0 && i >= 0){
            if(grid[i][j] == 'Q') return false;
            i--;
            j--;
        }
        i = r-1; j = c+1;  // ← top-right diagonal
        while(i >= 0 && j < n){
            if(grid[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }
}