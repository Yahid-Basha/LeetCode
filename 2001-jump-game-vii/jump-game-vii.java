class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {

        int dp[] = new int[s.length()];
        int preSum[] = new int[s.length()];
        dp[0] = 1;

        for(int i = 0; i < minJump; i++){
            preSum[i] = 1;
        }
        
        for (int i = minJump; i < s.length(); i++) {
    int upper = i - minJump;
    int lower = i - maxJump;
    
    // Check if any index in [lower, upper] is reachable
    int reachableInWindow;
    if (lower <= 0) {
        reachableInWindow = preSum[upper];
    } else {
        reachableInWindow = preSum[upper] - preSum[lower - 1];
    }

    if (s.charAt(i) == '0' && reachableInWindow > 0) {
        dp[i] = 1;
    }
    
    // Always accumulate the prefix sum based on the previous value
    preSum[i] = preSum[i - 1] + dp[i];
}
        if(dp[s.length()-1] == 1) return true;
        return false;
    }
}