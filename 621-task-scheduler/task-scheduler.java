class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        Queue<int[]> que = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));

        for(char c: tasks){
            freq[c-'A']++;
        }
        for(int i: freq){
            if(i > 0){
                pq.offer(i);
            }
        }
        int time = 0;
        while(!pq.isEmpty() || !que.isEmpty()){
            time++;
            if(pq.isEmpty()){
                time = que.peek()[1];
            }else{
                int frq = pq.poll()-1;
                if(frq > 0) que.offer(new int[]{frq, time+n});
            }
            if(!que.isEmpty() && time == que.peek()[1]){
                pq.offer(que.poll()[0]);
            }
        }
        return time;
    }
}