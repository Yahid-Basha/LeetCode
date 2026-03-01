
class Solution {
    class DSU{
    int[] parent;
    int rank[];
    int components;

    public DSU(int n){
        parent = new int[n];
        rank = new int[n];
        components = n;

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x){
        while(parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    boolean union(int x, int y){
        int px = find(x), py = find(y);
        if(px == py) return false;

        if(rank[px] > rank[py]){
            parent[py] = px;
            rank[px]+=rank[py];
        }else{
            parent[px] = py;
            rank[py]+=rank[px];
        }
        components--;
        return true;
    }

}
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU uf = new DSU(n+1);
        int[] ans = new int[2];
        for(int[] edge: edges){
            if(!uf.union(edge[0], edge[1])){
                ans = edge;
            }
        }
        return ans;
    }
}