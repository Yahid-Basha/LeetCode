class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        if(numRows == 1) return ans;
        ans.add(Arrays.asList(1,1));
        if(numRows == 2) return ans;

        for(int i = 2; i < numRows; i++){
            List<Integer> curr = new ArrayList<>();
            List<Integer> prev = ans.get(i-1);

            curr.add(1);
            for(int j = 0; j < prev.size()-1; j++){
                curr.add(prev.get(j)+prev.get(j+1));
            }
            curr.add(1);

            ans.add(curr);
        }
        return ans;
    }
}