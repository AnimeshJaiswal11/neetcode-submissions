class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                char x = text1.charAt(i), y = text2.charAt(j);
                if(i == 0 && j == 0){
                    dp[i][j] = x==y? 1 : 0;
                }
                else if(i == 0){
                    dp[i][j] = Math.max(dp[i][j-1], x==y? 1:0);
                }
                else if(j == 0){
                    dp[i][j] = Math.max(dp[i-1][j], x==y? 1:0);
                }
                else{
                    if(x == y){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
}
