class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> inp = new ArrayList<>();
        for(int i=0; i<nums.length; i++){ inp.add(nums[i]); }
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        subsetFinder(inp, ans, 0, solution);
        return solution;
    }
    public void subsetFinder(List<Integer> nums, List<Integer> ans, int i, List<List<Integer>> solution){
        if(i == nums.size()){
            solution.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums.get(i));
        subsetFinder(nums, ans, i+1, solution);
        ans.remove(Integer.valueOf(nums.get(i)));
        subsetFinder(nums, ans, i+1, solution);
    }
}