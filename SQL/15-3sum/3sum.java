class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length < 3){
            return ans;
        }
        if(nums.length == 3){
            if(nums[0]+nums[1]+nums[2] == 0){
                ArrayList<Integer> ls = new ArrayList<>();
                ls.add(nums[0]);
                ls.add(nums[1]);
                ls.add(nums[2]);
                ans.add(ls);
                return ans;
            } else {
                return ans;
            }
        }

        for(int i = 0; i < nums.length; i++){
            int left = i+1;
            int right = nums.length-1;
            if(nums[i] > 0) break;
                if(i > 0 && nums[i] == nums[i-1]){ 
                    continue; 
                }
                while(left<right){
                    if(nums[i]+nums[left]+nums[right] > 0){
                        right--;
                    }
                    else if(nums[i]+nums[left]+nums[right] < 0){
                        left++;
                    } else{
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left+=1;
                        while(left < right && nums[left] == nums[left-1]) left+=1;
                    }
                }
        }
        return ans;
    }
}