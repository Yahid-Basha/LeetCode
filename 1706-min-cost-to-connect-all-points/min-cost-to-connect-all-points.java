class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[2]-b[2]);
        boolean inMST[] = new boolean[n];

        minHeap.add(new int[]{points[0][0], points[0][1], 0, 0});
        int cost = 0;
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            if(inMST[curr[3]]) continue;
            inMST[curr[3]] = true;
            
            cost+=curr[2];

            for(int i = 0; i < n; i++){
                if(!inMST[i]){
                    int x1 = curr[0], x2 = points[i][0];
                    int y1 = curr[1], y2 = points[i][1];
                    int weight = Math.abs(x1-x2)+Math.abs(y1-y2);
                    minHeap.offer(new int[]{x2, y2, weight, i});
                }
            }
        }
        return cost;
    }
}