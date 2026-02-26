class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));

        int[] currentInterval = intervals[0];
        mergedIntervals.add(currentInterval);

        for(int i = 1; i < intervals.length; i++){
            int currStart = currentInterval[0];
            int currEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if(nextStart <= currEnd){
                currentInterval[1] = Math.max(currEnd, nextEnd);
            }else{
                currentInterval = intervals[i];
                mergedIntervals.add(currentInterval);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}