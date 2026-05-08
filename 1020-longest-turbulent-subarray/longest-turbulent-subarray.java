class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if(n < 2) return n;
        int max = 1, l = 0;

        for(int r = 1; r < n; r++){
            int curr = Integer.compare(arr[r-1], arr[r]);
            if(curr == 0){
                l = r;
            }else if(r > 1 && curr == -Integer.compare(arr[r-2], arr[r-1])){

            }else{
                l = r-1;
            }
            max = Math.max(r-l+1, max);
        }
        return max;
    }
    public int compare(int a, int b){
        if (a < b) return 1;
        if (a > b) return -1;
        return 0;
    }
}