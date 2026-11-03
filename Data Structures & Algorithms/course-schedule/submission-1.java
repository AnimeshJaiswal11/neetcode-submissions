class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            adj.get(pre[0]).add(pre[1]);
        }
        boolean[] pathVis = new boolean[numCourses];
        boolean[] vis = new boolean[numCourses];
        for (int i = 0 ; i < numCourses ; i++){
            if(helper(i, vis, pathVis, adj))
                return false;
        }
        return true;
    }
    
    public boolean helper(int v, boolean[] vis, boolean[] pathVis, ArrayList<ArrayList<Integer>> adj){
        vis[v] = true;
        pathVis[v] = true;
        for(int ver:adj.get(v)){
            if(!vis[ver]){
                if(helper(ver, vis, pathVis, adj))
                    return true;
            }
            if(pathVis[ver])
                return true;
        }
        pathVis[v] = false;
        return false;
        
    }
}
