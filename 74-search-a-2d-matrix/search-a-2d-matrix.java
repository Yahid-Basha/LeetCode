class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int Vstart = 0;
        int Vend = matrix.length-1;
        int Vmid = 0;
        while(Vstart <= Vend){
            Vmid = Vstart + (Vend-Vstart)/2;
            if(matrix[Vmid][0] == target){
                return true;
            } else if(matrix[Vmid][0] > target){
                Vend = Vmid-1;
            } else {
                Vstart = Vmid+1;
            }
        }
        int row = Vend;
        if(row < 0){
            return false;
        }
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