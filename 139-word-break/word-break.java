class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        dp = new Boolean[s.length()+1];
        return solve(s, 0, set);
        
    }
    public boolean solve(String s, int start, Set<String> dict){
        // base case
        if(start == s.length()) return true;

        if(dp[start] != null) return dp[start];

        //select the first word
        for(int i = start+1; i <= s.length(); i++){
            if(dict.contains(s.substring(start, i))){
                if(solve(s, i, dict)){
                    return dp[start]=true;
                } 
            }
        }
        return dp[start]=false;
        
    }
}