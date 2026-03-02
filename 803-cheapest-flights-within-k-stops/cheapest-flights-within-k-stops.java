class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for(int i = 0; i < k+1; i++){
            int[] temp = dist.clone();
            for(int[] edge: flights){
                int u = edge[0], v = edge[1], w = edge[2];
                if(temp[u] != Integer.MAX_VALUE && temp[u]+w < dist[v])
                    dist[v] = temp[u]+w;
            }
        }
        // return dist[dst];
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}