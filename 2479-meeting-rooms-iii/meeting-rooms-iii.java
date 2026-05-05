class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Long.compare(a[0], b[0]));
        PriorityQueue<long[]> used = new PriorityQueue<>((a, b) ->
            a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            available.offer(i);
        }
        int[] count = new int[n];

        for(int meeting[] : meetings){
            long start = meeting[0];
            long end = meeting[1];
            long duration = end-start;

            while(!used.isEmpty() && used.peek()[0] <= start){
                int room = (int) used.poll()[1];
                available.offer(room);
            }

            if(available.isEmpty()){
                long earliest = used.peek()[0];
                end = earliest + duration;
                int room = (int) used.poll()[1];
                available.offer(room);
            }
            
            int room = available.poll();
            used.offer(new long[]{end, room});
            count[room]++;
        }
        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxRoom]) {
                maxRoom = i;
            }
        }
        return maxRoom;
    }
}