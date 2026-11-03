class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0){
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        int curi = cur[0], curj = cur[1];
                        int count = grid[curi][curj];
                        for(int[] dir:dirs){
                            int ni = curi+dir[0], nj = curj+dir[1];
                            if(ni < 0 || nj < 0 || ni >= m || nj >= n || grid[ni][nj] == -1 || grid[ni][nj] == 0 || grid[ni][nj] <= count+1){
                                continue;
                            }
                            grid[ni][nj] = count+1;
                            queue.add(new int[]{ni, nj});
                        }
                    }
                }
            }
        }
    }
}
