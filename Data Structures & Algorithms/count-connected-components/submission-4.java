class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        for(int[] edge:edges){
            dsu.union(edge[0], edge[1]);
        }
        return dsu.components;
    }


}

class DSU{
    int[] parent;
    int components;
    int[] size;
    DSU(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
            size[i] = 1;
        }
        components = n;
    }
    public int find(int x){
        if(x != parent[x])
            parent[x] = find(parent[x]);
        return parent[x];
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
        parent[rb] = ra;
        size[ra] += size[ra];
        components--;
    }
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }

}
