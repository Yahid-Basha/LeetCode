class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Since locations are constrained (0 to 1000)
        int[] road = new int[1001];
        
        // Step 1: Record net changes at each location
        for (int[] trip : trips) {
            int numPass = trip[0];
            int from = trip[1];
            int to = trip[2];
            
            road[from] += numPass;
            road[to] -= numPass;
        }
        
        // Step 2: Sweep through the road to check capacity
        int currentLoad = 0;
        for (int change : road) {
            currentLoad += change;
            if (currentLoad > capacity) {
                return false;
            }
        }
        
        return true;
    }
}