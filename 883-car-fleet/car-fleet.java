class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int [][] pair = new int[n][2];
        if( n == 1) return n;
        for(int i = 0; i < n; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a,b)->Integer.compare(a[0], b[0]));

        Stack<Double> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            double time = (double)(target-pair[i][0])/pair[i][1];
            if(stack.isEmpty()){
                stack.add(time);
            }
            if(stack.peek() < time){
                stack.add(time);
            }
        }
        return stack.size();
    }
}