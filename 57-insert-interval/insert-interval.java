class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        boolean inserted = false;
        for(int i = 0; i < intervals.length; i++){
            int[] curr = intervals[i];

            if(curr[1] < newInterval[0]){
                //before (curr ends before new starts)
                ans.add(curr);
            }else if(curr[0] > newInterval[1]){
                // after (curr starts after new ends)
                if(!inserted) {
                    ans.add(newInterval);
                    inserted = true;
                }
                ans.add(curr);
            }else{
                newInterval[0] = Math.min(newInterval[0], curr[0]);
                newInterval[1] = Math.max(newInterval[1], curr[1]);
            }
        }
        if(!inserted){
            ans.add(newInterval);
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