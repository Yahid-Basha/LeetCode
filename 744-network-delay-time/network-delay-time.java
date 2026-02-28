class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        for(int i = 0; i < n; i++){
            for(int[] edge: times){
                int u = edge[0], v = edge[1], w = edge[2];
                if(dist[u] != Integer.MAX_VALUE && dist[v] > dist[u]+w){
                    dist[v] = dist[u]+w;
                }
            }
        }
        int time = 0;
        dist[0]=0;
        for(int t: dist){
            time = Math.max(t, time);
        }
        return time == Integer.MAX_VALUE ? -1 : time;
    }
}