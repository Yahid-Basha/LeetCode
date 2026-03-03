class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i, j, 0, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board, int r, int c, int i, String word){
        if(i == word.length()) return true;
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '#'|| i >= word.length() ) return false;
        if(board[r][c] != word.charAt(i)) return false;

        char temp = board[r][c];
        board[r][c] = '#';
            if(
                dfs(board, r+1, c, i+1, word) ||
                dfs(board, r-1, c, i+1, word) ||
                dfs(board, r, c+1, i+1, word) ||
                dfs(board, r, c-1, i+1, word) 
            ){
                board[r][c] = temp;
                return true;
            }
            board[r][c] = temp;
        return false;
    }
}