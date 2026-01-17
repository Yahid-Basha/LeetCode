class Solution {
    public int arrangeCoins(int n) {
        int row = 1;
        while(n > 0){
            n = n-row;
            if(n > 0) row++;
            // row++;
        }
        return n < 0 ? row-1 : row;
    }
}