class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for(char[] row: grid){
            Arrays.fill(row, '.');
        }
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        List<List<String>> res = new ArrayList<>();
        dfs(grid, 0, n, res, cols, posDiag, negDiag);
        return res;
    }
    void dfs(char[][] grid, int r, int n, List<List<String>> res,  Set<Integer> cols,  Set<Integer> posDiag,  Set<Integer> negDiag){
        if(r == n){
            List<String> ans = new ArrayList<>();
            for(char[] arr: grid){
                ans.add(new String(arr));
            }
            res.add(ans);
            return;
        }
        for(int i = 0; i < n; i++){
            if(cols.contains(i) || posDiag.contains(r+i) || negDiag.contains(r-i)) continue;

            cols.add(i);
            posDiag.add(r+i);
            negDiag.add(r-i);

            grid[r][i] = 'Q';
            dfs(grid, r+1, n, res, cols, posDiag, negDiag);
            grid[r][i] = '.';

            cols.remove(i);
            posDiag.remove(r+i);
            negDiag.remove(r-i);
            
        }
    }
}