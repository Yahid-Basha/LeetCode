class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int []> stack = new Stack<>();
        int n = temperatures.length;
        int ans[] = new int[n];

        for(int i =0; i < n; i++){
            if(stack.isEmpty()){
                stack.add(new int[] {temperatures[i], i});
                continue;
            }
            while(stack.size() > 0 && stack.peek()[0] < temperatures[i]){
                ans[stack.peek()[1]] = i - stack.peek()[1];
                stack.pop();
            }
            stack.add(new int[] {temperatures[i], i});
        }

        for(int[] a : stack){
            ans[a[1]] = 0;
        }

        return ans;
    }
}