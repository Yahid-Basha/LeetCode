class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[2]-b[2]);
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        minHeap.add(new int[]{0,0,grid[0][0]});
        int dirs[][] = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        int time = 0;
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            visited[curr[0]][curr[1]] = true;
            if(curr[0] == grid.length -1 && curr[1] == grid[0].length-1 ) return curr[2];
            for(int dir[]: dirs){
                int r = curr[0]+dir[0];
                int c = curr[1]+dir[1];
                if(c >= 0 && r >= 0 && c < grid[0].length && r < grid.length && !visited[r][c]){
                    minHeap.offer(new int[]{r, c,  Math.max(curr[2], grid[r][c])});
                }
            }
        }
        return time;
    }
}