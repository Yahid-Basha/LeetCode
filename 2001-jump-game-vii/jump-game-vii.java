class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n-1) != '0') return false;

        int dp[] = new int[n];
        dp[0]=1;

        int preSum[] = new int[n+1];
        preSum[0] = 0;

        for(int i = 0; i < n; i++){
            if(i >= minJump){
                int upper = i - minJump;
                int lower = Math.max(i - maxJump, 0);

                int reachable = preSum[upper+1]-preSum[lower];
                if(s.charAt(i) == '0' && reachable > 0){
                    dp[i] = 1;
                }
            }
            preSum[i+1] = preSum[i] + dp[i];
        }

        return dp[n-1] > 0;
    }
}