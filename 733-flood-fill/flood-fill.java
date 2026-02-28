class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int source = image[sr][sc];
        if(source == color) return image; 
        fill(image, sr, sc, source, color);
        return image;

    }
    void fill(int[][] matrix, int r, int c, int source, int color){
        if(c < 0 || r < 0 || c >= matrix[0].length || r >= matrix.length || matrix[r][c] != source ) return;
        matrix[r][c] = color;
        fill(matrix, r+1, c, source, color);
        fill(matrix, r-1, c, source, color);
        fill(matrix, r, c+1, source, color);
        fill(matrix, r, c-1, source, color);
        return;
    }
}