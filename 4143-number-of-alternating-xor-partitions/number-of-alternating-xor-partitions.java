class Solution {
    public int alternatingXOR(int[] nums, int target1, int target2) {
        int MOD = 1_000_000_007;
        
        // Maps to store counts of valid partitions for a given Prefix XOR
        // key: Prefix XOR, value: Count of ways
        Map<Integer, Integer> endsInT1 = new HashMap<>();
        Map<Integer, Integer> endsInT2 = new HashMap<>();
        
        // Base case: "Virtual" start. We pretend we finished a T2 block 
        // with prefix 0, so we are ready to accept a T1 block.
        endsInT2.put(0, 1);
        
        int currXor = 0;
        int totalWaysEndingHere = 0;

        for (int num : nums) {
            currXor ^= num;
            int waysT1 = endsInT2.getOrDefault(currXor ^ target1, 0);
            int waysT2 = endsInT1.getOrDefault(currXor ^ target2, 0);
            int currentCountT1 = endsInT1.getOrDefault(currXor, 0);
            endsInT1.put(currXor, (currentCountT1 + waysT1) % MOD);
            
            int currentCountT2 = endsInT2.getOrDefault(currXor, 0);
            endsInT2.put(currXor, (currentCountT2 + waysT2) % MOD);
            
            totalWaysEndingHere = (waysT1 + waysT2) % MOD;
        }
        return totalWaysEndingHere;
    }
}