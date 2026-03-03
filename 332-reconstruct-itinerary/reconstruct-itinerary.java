class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket: tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            map.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
            map.putIfAbsent(to, new PriorityQueue<>());
        }
        Stack<String> stack = new Stack<>();
        List<String> ans = new ArrayList<>();
        dfs(map, "JFK", ans);
        Collections.reverse(ans);
        return ans;
    }
    void dfs(Map<String, PriorityQueue<String>> map,String src, List<String> ans){
        while(!map.get(src).isEmpty()){
            String dest = map.get(src).poll();
            dfs(map, dest, ans);
        }
        ans.add(src);
    }
}