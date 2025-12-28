class Solution {
    private void findSubsets(int ind, int[] arr, Set<List<Integer>> ans, List<Integer> ds){
        if(ind == arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[ind]);
        findSubsets(ind+1 ,arr , ans, ds);
        ds.remove(ds.size()-1);
        findSubsets(ind+1 ,arr, ans, ds);
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        findSubsets(0, nums, ans, new ArrayList<>());
        return new ArrayList<>(ans);
    }
}