class Solution {
    private void findSubsets(int ind, int[] arr, List<List<Integer>> ans, List<Integer> ds){
        ans.add(new ArrayList<>(ds));
       
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i] == arr[i - 1]) continue;
            ds.add(arr[i]);
            findSubsets(i+1 ,arr , ans, ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(0, nums, ans, new ArrayList<>());
        return ans;
    }
}