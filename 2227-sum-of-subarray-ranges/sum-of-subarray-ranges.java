class Solution {
    public long subArrayRanges(int[] nums) {
        return solve(nums, true) - solve(nums, false);
    }
    public long solve(int[] nums, boolean isMax){
        int n = nums.length;
        long total = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i <= n; i++){
            while(!stack.isEmpty() && isPop(stack.peek(), i, n, nums, isMax)){
                int midIndex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightIndex = i;

                long count = (long)(midIndex - leftIndex) * (long)(rightIndex - midIndex);
                total += count*nums[midIndex];
            }
            stack.push(i);
        }
        return total;
    }
    public boolean isPop(int midIndex, int currIndex, int n, int[] nums, boolean isMax){
        if(currIndex == n) return true;
        int top = nums[midIndex];
        int curr = nums[currIndex];

        if(isMax){
            return curr > top;
        }else{
            return top > curr;
        }
    }
}