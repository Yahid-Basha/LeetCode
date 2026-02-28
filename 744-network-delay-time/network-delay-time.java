class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : times){
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{k, 0});


        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            if(curr[1] > dist[u]) continue;
            for(int[] edge: adj.get(u)){
                int v = edge[0], w = edge[1];
                if(dist[v] <= dist[u]+w) continue;
                dist[v] = dist[u]+w;
                pq.offer(new int[] {v, dist[v]});
            }
        }
        int time = 0;
        
        for(int i =1; i < n+1; i++){
            time = Math.max(dist[i], time);
        }
        return time == Integer.MAX_VALUE ? -1 : time;
    }
}