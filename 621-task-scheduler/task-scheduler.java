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
                // if heap is empty skip to next time (skipped parts are idle)
                time = que.peek()[1];
            }else{
                // next high frequent item polled and pushed to que
                int count = heap.poll()-1;
                if(count > 0) que.offer(new int[]{count, time+n});
            }

            // scnario where an item is available from queue 
            if(!que.isEmpty() && time == que.peek()[1]){
                heap.offer(que.poll()[0]);
            }
        }
        return time;
    }
}