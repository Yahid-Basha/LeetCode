class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for(int num : nums){
            if(num!=val){
                nums[idx] = num;
                idx++;
            }
        }
        return idx;
    }
}