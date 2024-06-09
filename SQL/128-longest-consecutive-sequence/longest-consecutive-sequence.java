class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int max = 1;
        if(nums.length == 0){
            return 0;
        }
        
        for(int i = 1; i < nums.length; i++){
            
           if(nums[i]-nums[i-1] <= 1){
            count+=1;
            if(nums[i]-nums[i-1] == 0){
                count-=1;
            }
            if(max < count){
                max = count;
            }
           } else {
            count = 1;
           }
        }
        return max;
    }
}