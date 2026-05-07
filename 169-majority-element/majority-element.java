class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int votes = 0;
        for(int i: nums){
            if(votes == 0){
                candidate = i;
                votes = 1;
            }else if(candidate == i){
                votes++;
            }else{
                votes--;
            }
        }
        return candidate;
    }
}