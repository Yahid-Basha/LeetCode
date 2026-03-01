class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> ans = new Stack<>();
        int[] res = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[numCourses], recStack = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: prerequisites){
            int u = edge[1], v = edge[0];
            adj.get(u).add(v);
        }
        for(int i = 0; i < numCourses; i++){
            if(!visited[i] && dfs(i, adj, visited, recStack, ans)){
                return new int[]{};
            }
        }
        int i = 0;
        while(!ans.isEmpty()){
            res[i] = ans.pop();
            i++;
        }
        return res;
    }
    boolean dfs(int curr, List<List<Integer>> adj, boolean[] visited, boolean[] recStack, Stack<Integer> ans){
        visited[curr] = true;
        recStack[curr] = true;

        for(int i: adj.get(curr)){
            if(recStack[i]) return true;
            if(!visited[i] && dfs(i, adj, visited, recStack, ans)){
                visited[i] = true;
                return true;
            }
        }
        recStack[curr] = false;
        ans.add(curr);
        return false;
    }
}