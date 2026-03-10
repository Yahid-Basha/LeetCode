class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        int[] last = intervals[0];
        int count = 0;
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(last[1] > curr[0]){
                count++;
                if(last[1] > curr[1]){
                    last = curr;
                }
            }else{
                last = curr;
            }
        }
        return count;
    }
}