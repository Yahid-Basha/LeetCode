class Solution {
    public int removeDuplicates(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]>max){
                max = nums[i];
                nums[curr] = nums[i];
                curr++;
            }
        }
        return curr;
    }
}