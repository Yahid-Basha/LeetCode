class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int votes = 0;
        for(int i: nums){
            if(candidate == i){
                votes++;
            }else{
                votes--;
            }
            if(votes == 0){
                candidate = i;
                votes = 1;
            }
        }
        return candidate;
    }
}