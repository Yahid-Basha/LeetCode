class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[][] sortedQueries = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries,(a,b) -> a[0]-b[0]);
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int[] ans = new int[queries.length];
        int j = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((a[1]-a[0]) - (b[1]-b[0])));
        for(int i = 0; i < queries.length; i++){
            int q = sortedQueries[i][0];
            while(j < intervals.length && intervals[j][0] <= q){
                pq.offer(intervals[j]);
                j++;
            }
            while(!pq.isEmpty() && pq.peek()[1] < q){
                pq.poll();
            }
            if(!pq.isEmpty()){
                int[] interval = pq.peek();
                ans[sortedQueries[i][1]] = interval[1]-interval[0]+1;
            }else{
                ans[sortedQueries[i][1]] = -1;
            }
        }
        return ans;
    }
}