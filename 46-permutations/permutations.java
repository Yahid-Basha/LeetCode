class Solution {
    public List<List<Integer>> permute(int[] nums) {

        Set<Integer> source = new LinkedHashSet<>();
        for (int next: nums) source.add(next);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(source,cur,ans);
        return ans;
    }
    public void backtrack(Set<Integer> source, List<Integer> cur, List<List<Integer>> ans){
        if(source.isEmpty()){
            ans.add(cur);
            return;
        }

        for(Integer next: source){
            List<Integer> updatedCur = new ArrayList<>(cur);
            updatedCur.add(next);
            Set<Integer> updatedSource = new LinkedHashSet<>(source);
            updatedSource.remove(next);
            backtrack(updatedSource, updatedCur, ans);
        }
    }
}
