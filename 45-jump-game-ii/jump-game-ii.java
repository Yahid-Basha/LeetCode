class Solution {
    public int jump(int[] nums) {
        int currLimit = 0;
        int maxJump = 0;
        int jump = 0;
        for(int i =0; i < nums.length-1; i++){
            maxJump = Math.max(maxJump, i+nums[i]);
            if(i == currLimit){
                jump++;
                currLimit = maxJump;
            }
        }
        return jump;
    }
}