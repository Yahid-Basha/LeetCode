class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int[][] machines = new int[n][2];

        // 1. Combine cost and capacity
        for (int i = 0; i < n; i++) {
            machines[i][0] = costs[i];     // Cost
            machines[i][1] = capacity[i];  // Capacity
        }

        // 2. Sort by Cost
        Arrays.sort(machines, (a, b) -> Integer.compare(a[0], b[0]));

        // 3. Create Prefix Max Capacity Array
        // maxCaps[i] will store the max capacity found in machines[0...i]
        int[] maxCaps = new int[n];
        maxCaps[0] = machines[0][1];
        for (int i = 1; i < n; i++) {
            maxCaps[i] = Math.max(maxCaps[i - 1], machines[i][1]);
        }

        int maxCapacity = 0;

        // 4. Iterate and find best pairs
        for (int i = 0; i < n; i++) {
            int currentCost = machines[i][0];
            int currentCap = machines[i][1];

            // Case A: Pick only this machine (must be strictly less than budget)
            if (currentCost < budget) {
                maxCapacity = Math.max(maxCapacity, currentCap);
            } else {
                // Since array is sorted, if this single machine is >= budget, 
                // any pair involving it will also be >= budget.
                continue; 
            }

            // Case B: Pick this machine + one previous machine
            int remaining = budget - currentCost;
            
            // We need a machine with cost < remaining. 
            // We use Binary Search to find the rightmost index 'idx' where machines[idx].cost < remaining
            int idx = binarySearch(machines, i - 1, remaining);
            
            if (idx != -1) {
                maxCapacity = Math.max(maxCapacity, currentCap + maxCaps[idx]);
            }
        }

        return maxCapacity;
    }

    // Helper: Find rightmost index in range [0, high] with cost < target
    private int binarySearch(int[][] machines, int high, int target) {
        int low = 0;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (machines[mid][0] < target) {
                res = mid; // This is a candidate, try to go right to find a more expensive one (optional, but standard BS)
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}