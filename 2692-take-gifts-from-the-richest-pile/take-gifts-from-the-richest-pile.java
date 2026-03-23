class Solution {
    public long pickGifts(int[] gifts, int k) {
        int m = gifts.length;

        int t = k + 1;

        Queue<Integer> q = new PriorityQueue<>(gifts.length, (a, b) -> b - a); 

        for (int item : gifts) q.offer(item);

        while (--t > 0) {
            int readd = (int) Math.sqrt(q.poll());
            q.offer(readd);
        } 

        long sum = 0;
        for (int item : q) sum += item;

        return sum;
    } 
}