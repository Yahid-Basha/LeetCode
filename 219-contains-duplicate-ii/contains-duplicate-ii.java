class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if( k == 0 ) return false;
        int r = 0;
        Set<Integer> set = new HashSet<>();
        while(r < nums.length){
            if(set.contains(nums[r])) return true;
            set.add(nums[r]);
            if(set.size() > k) set.remove(nums[r-k]);
            r++;
        }
        return false;
    }
}