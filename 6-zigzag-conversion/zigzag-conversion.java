class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || s.length() <= numRows) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) rows[i] = new StringBuilder();

        boolean goingDown = false;
        int row = 0;
        for(char c: s.toCharArray()){
            rows[row].append(c);

            if(row == numRows-1 || row == 0){
                goingDown = !goingDown;
            }

            row += goingDown ? 1 : -1;
        }

        for(int i = 1; i < numRows; i++) rows[0].append(rows[i]);
        return rows[0].toString();
    }
}