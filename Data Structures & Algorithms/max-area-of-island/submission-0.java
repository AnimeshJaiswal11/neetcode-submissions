class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, helper(grid, i, j, res));
                }
            }
        }
        return res;
    }

    public int helper(int[][] grid, int i, int j, int res){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        int count = 1;
        grid[i][j] = 0;
        count += helper(grid, i+1, j, res);
        count += helper(grid, i-1, j, res);
        count += helper(grid, i, j-1, res);
        count += helper(grid, i, j+1, res);
        return count;
    }
}
