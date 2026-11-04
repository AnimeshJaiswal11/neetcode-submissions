class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                count++;
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                vis[i] = true;
                while(!stack.isEmpty()){
                    int cur = stack.pop();
                    for(int u : adj.get(cur)){
                        if(!vis[u]){
                            stack.push(u);
                            vis[u] = true;
                        }
                    }
                }
            }
        }
        return count;
    }
}
