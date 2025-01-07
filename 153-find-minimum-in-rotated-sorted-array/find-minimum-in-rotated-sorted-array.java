class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length;
        int target = Integer.MAX_VALUE;
        int n = nums.length;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] < target) {
                target = nums[mid];
            }
            if(nums[mid] > nums[n-1]){
                left = mid+1;
            }else{
                right = mid - 1;
            }
        }
        return target;
    }
}
