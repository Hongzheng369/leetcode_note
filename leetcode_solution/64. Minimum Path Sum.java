class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int[] line: dp){
            Arrays.fill(line, Integer.MAX_VALUE);
        }
        dp[m - 1][n] = 0;
        dp[m][n - 1] = 0;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }
}