class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int INF = 2147483647;
        int m = grid.length, n = grid[0].length;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0)
                    queue.add(new int[]{i, j});
            }
        }
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                int[] cur = queue.poll();
                for(int[] dir:dirs){
                    int ni = cur[0]+dir[0], nj = cur[1]+dir[1];
                    if(ni < 0 || nj < 0 || ni >= m || nj >= n || grid[ni][nj] != INF)
                        continue;
                    grid[ni][nj] = count;
                    queue.add(new int[]{ni, nj});
                }
            }
            count++;
        }
    }
}
