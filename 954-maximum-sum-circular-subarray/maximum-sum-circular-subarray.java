class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0], currMax = 0;
        int minSum = nums[0], currMin = 0;

        for(int x: nums){
            currMax = Math.max(x, currMax + x);
            maxSum = Math.max(currMax, maxSum);

            currMin = Math.min(x, currMin + x);
            minSum = Math.min(minSum, currMin);

            totalSum += x;
        }
        
        return maxSum > 0 ? Math.max(maxSum, totalSum-minSum) : maxSum;

    }
}