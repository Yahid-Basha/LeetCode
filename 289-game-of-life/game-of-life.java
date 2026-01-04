class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int liveNeighbors = countLive(board, i, j, m, n);

                if(board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)){
                    board[i][j] = 2;
                }

                if(board[i][j] == 0 && liveNeighbors == 3){
                    board[i][j] = 3;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2) board[i][j] = 0;
                if(board[i][j] == 3) board[i][j] = 1;
            }
        }
    }

    public int countLive(int[][] board, int row, int col, int m, int n){
        int count = 0;
        for(int i = row-1; i <= row+1; i++){
            for(int j = col-1; j <= col+1; j++){
                if(i >= 0 && i < m && j >= 0 && j < n){
                    if(board[i][j] ==  1 || board[i][j] == 2){
                        count++;
                    }
                }
            }
        }
        if(board[row][col] == 1) count--;
        return count;
    }
}