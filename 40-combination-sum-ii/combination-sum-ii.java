class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, target, 0, new ArrayList<>(), res);
        return res;
    }
    void dfs(int[] candidates,int start, int target, int currSum, List<Integer> ans, List<List<Integer>> res){
        if(currSum > target) return;
        if(target == currSum){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if( i > start && candidates[i] == candidates[i-1]) continue;
            // if(currSum + candidates[i] > target) break;
            ans.add(candidates[i]);
            dfs(candidates, i+1, target, currSum+candidates[i],ans, res);
            ans.remove(ans.size()-1);
        }

    }
}