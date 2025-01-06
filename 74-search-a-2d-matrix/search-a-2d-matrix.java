class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int top = 0;
        int bot = matrix.length-1;
        while(top <= bot){
            int row = top + (bot-top)/2;
            if(matrix[row][matrix[0].length-1] < target){
                top = row+1;
            }else if(matrix[row][0] > target){
                bot = row-1;
            }else{
                break;
            }
        }

        if(top > bot) return false;
        int row = top + (bot-top)/2;
        
        int start = 0;
        int end = matrix[row].length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(matrix[row][mid] == target){
                return true;
            } else if(matrix[row][mid] > target){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        
        return false;
    }
}