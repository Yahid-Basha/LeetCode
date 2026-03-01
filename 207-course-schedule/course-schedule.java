class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: prerequisites){
            int u = edge[1], v = edge[0];
            adj.get(u).add(v);
        }
        boolean[] visited = new boolean[numCourses], recStack = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(dfs(i, adj, visited, recStack)){
                return false;
            }
        }
        return true;
    }
    boolean dfs(int curr, List<List<Integer>> adj,  boolean[] visited,  boolean[] recStack){ //ret true - cyc exists false - cyc doesn't exist
        visited[curr] = true;
        recStack[curr] = true;

        for(int i: adj.get(curr)){
            if(recStack[i]) return true;
            if(!visited[i] && dfs(i, adj, visited, recStack)){
                return true;
            }
        }
        recStack[curr] = false;
        return false;
    }
}