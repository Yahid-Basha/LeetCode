class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currLimit = 0;
        int maxSoFar = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(i == nums.length - 1) return jumps;
            maxSoFar = Math.max(maxSoFar, i+nums[i]);
            if(i == currLimit){
                jumps++;
                currLimit = maxSoFar;
                if(currLimit > nums.length-1){
                    return jumps;
                }
            }
        }
        return jumps;
    }
}