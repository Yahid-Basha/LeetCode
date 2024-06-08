class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            if(!set.contains(i)){
                set.add(i);
            } else{
                return true;
            }
        }
        return false;
    }
}