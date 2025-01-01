class Solution {
    public int removeElement(int[] nums, int val) {
        int count = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if (nums[i] == val){
                nums[i] = nums[count-1];
                count--;
            }
        }
        return count;
    }
}