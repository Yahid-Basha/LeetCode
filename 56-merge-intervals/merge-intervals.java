class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        ans.add(intervals[0]);
        for(int i = 0; i < intervals.length; i++){
            int[] prev = ans.remove(ans.size()-1);
            int[] curr = intervals[i];

            if(prev != null && curr[0] <= prev[1]){
                ans.add(new int[]{prev[0], Math.max(curr[1], prev[1])});
            }else{
                ans.add(prev);
                ans.add(curr);
            }
        }
        int[][] result = new int[ans.size()][2];
        int i = 0;
        for(int[] interval : ans){
            result[i] = interval;
            i++;
        }
        return result;
    }
}