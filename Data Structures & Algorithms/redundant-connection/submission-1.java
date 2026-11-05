class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);
        for(int[] edge:edges){
            if(dsu.isConnected(edge[0]-1, edge[1]-1))
                return new int[]{edge[0], edge[1]};
            dsu.union(edge[0]-1, edge[1]-1);
        }
        return new int[]{};
    }


}
class DSU{

    int[] parent;
    int[] size;
    int components;

    DSU(int n){
        components = n;
        parent = new int[n];
        size = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }

    public void union(int x, int y){
        if(isConnected(x, y))
            return;
        int ra = find(x), rb = find(y);
        if(size[ra] < size[rb]){
            int temp = rb;
            rb = ra;
            ra = temp;
        }
        size[ra] += size[rb];
        parent[rb] = parent[ra];
        components--;
    }

}