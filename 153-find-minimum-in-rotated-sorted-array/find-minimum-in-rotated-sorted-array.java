class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;
        int target = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] < target){
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