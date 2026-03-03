class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[] pacific[] = new boolean[m][n];  
        boolean[] atlantic[] = new boolean[m][n];  
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    flow(heights, pacific, i, j , 0);
                }
                if(i == m-1 || j == n-1){
                    flow(heights, atlantic, i, j, 0);
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List coord = new ArrayList<>();
                    coord.add(i);
                    coord.add(j);
                    ans.add(coord);
                }
            }
        }
        return ans;
    }
    void flow(int[][] heights, boolean[][] visited, int r, int c, int prevHeight){
        if(r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || prevHeight > heights[r][c]|| visited[r][c]) return;
        visited[r][c] = true;
        flow(heights, visited, r+1, c, heights[r][c]);
        flow(heights, visited, r-1, c, heights[r][c]);
        flow(heights, visited, r, c+1, heights[r][c]);
        flow(heights, visited, r, c-1, heights[r][c]);
    }
}