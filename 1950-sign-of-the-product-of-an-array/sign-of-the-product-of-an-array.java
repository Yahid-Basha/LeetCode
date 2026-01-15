class Solution {
    public int arraySign(int[] nums) {
    int negativeCount = 0;
    
    for (int num : nums) {
        if (num == 0) return 0; // Immediate exit
        if (num < 0) negativeCount++;
    }
    
    // If negativeCount is even, return 1, else -1
    return (negativeCount % 2 == 0) ? 1 : -1;
}
}