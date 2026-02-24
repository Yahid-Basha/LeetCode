class Solution {

    public boolean exist(char[][] board, String word) {
        String ans = new String("");
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board,i, j, 0, word, m, n)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean backtrack(char[][] board, int i, int j, int idx,String word, int m, int n){
        if(i < 0|| i >= m || j < 0 || j >= n||board[i][j]!=word.charAt(idx)) return false;
        if(idx == word.length()-1) return true;

        board[i][j] = '#';

        if(
            backtrack(board,i-1,j,idx+1,word, m, n) || 
            backtrack(board,i+1,j,idx+1,word, m, n) || 
            backtrack(board,i,j-1,idx+1,word, m, n) || 
            backtrack(board,i,j+1,idx+1,word, m, n) 
        ){
            return true;
        }

        board[i][j] = word.charAt(idx);
        return false;

    }
}
