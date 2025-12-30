class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int ans[] = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            
            while (!stack.isEmpty() && temperatures[i] >= temperatures[Integer.valueOf(stack.peek())]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = Integer.valueOf(stack.peek()) - i;
            }
            stack.push(i);
        }
        return ans;
    }
}