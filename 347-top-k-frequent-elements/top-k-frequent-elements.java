class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(int i: map.keySet()){
            pq.add(i);
        }
        // System.out
        int[] ans = new int[k];
        int i = 0;
        while(i<k){
            ans[i] = pq.remove();
            i++;
        }
        return ans;
    }
}