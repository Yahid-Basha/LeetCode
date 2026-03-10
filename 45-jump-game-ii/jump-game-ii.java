class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currLimit = 0;
        int maxSoFar = 0;
        for(int i = 0; i < nums.length-1; i++){
            maxSoFar = Math.max(maxSoFar, i+nums[i]);
            if(i == currLimit){
                jumps++;
                currLimit = maxSoFar;
            }
        }
        return jumps;
    }
}