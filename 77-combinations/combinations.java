class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        solve(1, n, k, new ArrayList<>());
        return ans;
    }
    public void solve(int i, int n, int k, List<Integer> curr){
        if(curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int next = i; next <= n; next++){
            curr.add(next);
            solve(next+1, n, k, curr);
            curr.remove(curr.size()-1);
        }
        return;
    }
}