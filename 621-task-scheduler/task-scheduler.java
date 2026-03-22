class Solution {
    public int leastInterval(char[] tasks, int n) {
        int counts[] = new int[26];
        for(char c: tasks){
            counts[c-'A']++;
        }
        int time = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->(b-a));
        for(int count: counts){
            if(count > 0)
            heap.offer(count);
        }
        Queue<int[]> que = new LinkedList<>();
        while(!heap.isEmpty() || !que.isEmpty()){
            time++;

            if(heap.isEmpty()){
                time = que.peek()[1];
            }else{
                int count = heap.poll()-1;
                if(count > 0){
                    que.offer(new int[]{count, time+n});
                }
            }

            if(!que.isEmpty() && que.peek()[1] == time){
                heap.offer(que.poll()[0]);
            }
        }
        return time;
    }
}