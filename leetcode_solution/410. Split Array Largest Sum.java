class Solution {
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        int[][] dp = new int[len][m + 1];
        for(int[] line: dp)
            Arrays.fill(line, Integer.MAX_VALUE);
        int[] sub = new int[len];
        sub[0] = nums[0];
        for(int i = 1; i < len; i++){
            sub[i] = sub[i - 1] + nums[i];
        }
        for(int i = 0; i < len; i++)
            dp[i][1] = sub[i];
        for(int i = 2; i <= m; i++){
            for(int j = i - 1; j < len; j++){
                for(int k = 0; k < j; k++){
                    dp[j][i] = Math.min(dp[j][i], Math.max(dp[k][i - 1], sub[j] - sub[k]));
                }
            }
        }
        return dp[len - 1][m];
    }
}