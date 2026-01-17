class Solution {
    public int arrangeCoins(int n) {
        long start = 0;
        long end = n;
        
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long coinsNeeded = mid * (mid + 1) / 2;
            
            if(coinsNeeded == n) return (int)mid;
            if(coinsNeeded < n){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        
        // Since we want the completed rows, 'end' will point to the largest k 
        // where k*(k+1)/2 <= n after the loop breaks.
        return (int) end; 
    }
}