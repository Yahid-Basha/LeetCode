class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i: stones){
            pq.offer(i);
        }

        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();
            if(x != y){
                pq.offer(y-x);
            }
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}