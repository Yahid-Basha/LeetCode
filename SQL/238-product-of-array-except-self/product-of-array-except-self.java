class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] pre = new int [nums.length];
        int [] post = new int [nums.length];
        pre[0] = 1;
        post[nums.length-1] = 1;
        for(int i = 1, j = nums.length-2 ; i<nums.length && j>=0; i++, j--){
            pre[i] = nums[i-1]*pre[i-1];
            post[j] = nums[j+1] * post[j+1];
        }
        int [] output = new int [nums.length];
        for(int i = 0; i< nums.length; i++){
            output[i] = pre[i]*post[i];
        }
        return output;
    }
}