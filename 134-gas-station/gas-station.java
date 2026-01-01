class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalsurplus = 0;
        int start = 0;
        int currtank = 0;

        for(int i = 0; i < gas.length; i++){
            int net = gas[i] - cost[i];
            totalsurplus += net;
            currtank += net;

            if(currtank < 0){
                start = i+1;
                currtank = 0;
            }
        }
        return (totalsurplus < 0) ? -1 : start;
    }
}