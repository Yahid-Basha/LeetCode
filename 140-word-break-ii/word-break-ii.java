class Solution {
    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        solve(0, s, wordDict, new StringBuilder());
        return res;
    }
    public void solve(int i, String s, List<String> wordDict, StringBuilder sb){
        if( i == s.length()){
            res.add(sb.toString());
            return;
        }
        for(String w: wordDict){
            if(i+w.length() <= s.length()){
                if(s.substring(i, i+w.length()).equals(w)){
                    int length = sb.length();
                    if(!sb.isEmpty()){
                        sb.append(" ");
                    }
                    sb.append(w);
                    solve(i+w.length(), s, wordDict, sb);
                    sb.setLength(length);
                }
            }
        }
    }
}