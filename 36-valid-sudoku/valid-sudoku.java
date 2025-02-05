class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> cols[] = new HashSet[9];
        Set<Character> rows[] = new HashSet[9];
        Set<Character> sqrs[][] = new HashSet[3][3];

        for(int i = 0; i < 9; i++){
            cols[i] = new HashSet<>();
            rows[i] = new HashSet<>();
        }
        for(int r = 0; r < 3; r++){ 
            for(int c = 0; c < 3; c++){
                sqrs[r][c] = new HashSet<>();
            }
        }

        for(int r = 0; r < 9; r++){ 
            for(int c = 0; c < 9; c++){
                if(board[r][c] == '.') continue;
            
            char ch = board[r][c];
            if(rows[r].contains(ch) || cols[c].contains(ch) || sqrs[r/3][c/3].contains(ch)){
                return false;
            }
            rows[r].add(ch);
            cols[c].add(ch);
            sqrs[r/3][c/3].add(ch);
        }
        }
        return true;
    }
}