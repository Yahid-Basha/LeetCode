class Solution {
    public List<String> letterCombinations(String digits) {
        String[] phone = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()) return ans;  // ← add before dfs call
        dfs(digits, phone, 0, new StringBuilder(), ans);
        return ans;
    }
    void dfs(String digits, String[] phone, int start, StringBuilder sb, List<String> ans){
        if(sb.length() == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String s = phone[digits.charAt(start)-'2'];
        for(int j = 0; j < s.length(); j++){
            sb.append(s.charAt(j));
            dfs(digits, phone, start+1, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}