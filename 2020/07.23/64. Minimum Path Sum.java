class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        //for(int[] line: dp)
          //  Arrays.fill(line, Integer.MAX_VALUE);
        //dp[rows - 1][cols] = 0;
        //dp[rows][cols - 1] = 0;
        for(int i = rows - 1; i >= 0; i--){
            for(int j = cols - 1; j >= 0; j--){
                if(i == rows - 1 && j == cols - 1)  dp[i][j] = grid[i][j];
                else if(i == rows - 1)  dp[i][j] = dp[i][j + 1] + grid[i][j];
                else if(j == cols - 1)  dp[i][j] = dp[i + 1][j] + grid[i][j];
                else    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }
}