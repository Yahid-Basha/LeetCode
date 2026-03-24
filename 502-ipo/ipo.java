class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capitals) {
        PriorityQueue<Integer> capital = new PriorityQueue<>((a,b)->(capitals[a]-capitals[b]));
        PriorityQueue<Integer> profit = new PriorityQueue<>((a,b)->(b-a));

        for(int i = 0; i < profits.length; i++){
            capital.offer(i);
        }

        for(int i = 0; i < k; i++){
            while(!capital.isEmpty() && capitals[capital.peek()] <= w){
                profit.offer(profits[capital.poll()]);
            }
            if(!profit.isEmpty())
            w+=profit.poll();
        }
        return w;
    }
}