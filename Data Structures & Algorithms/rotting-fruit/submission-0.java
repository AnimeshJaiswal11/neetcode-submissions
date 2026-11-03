class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2)
                    queue.add(new int[]{i, j});
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }
        if(fresh == 0)
            return 0;
        int minutes = -1;
        int rotten = 0;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                int[] cur = queue.poll();
                for(int[] dir:dirs){
                    int ni = cur[0]+dir[0], nj = cur[1]+dir[1];
                    if(ni < 0 || nj < 0 || ni >= m || nj >= n || grid[ni][nj] != 1)
                        continue;
                    queue.add(new int[]{ni, nj});
                    grid[ni][nj] = -1;
                    rotten++;
                }
            }
            minutes++;
        }
        return fresh == rotten ? minutes : -1;
    }
}
