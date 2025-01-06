class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i: piles){
            if(i > max) max = i;
        }
        int l = 1;
        int r = max;
        int ans = max;
        while(l <= r){
            long sum = 0;
            int m = l + (r-l)/2;

            for(int i: piles){
                sum += (i + m - 1) / m;  // Cleaner way to do ceiling division
            }
            if(sum <= h){
                ans = Math.min(ans, m);
                r = m - 1;
            }else{
                l = m+1;
            }
        }
        return ans;
    }
}