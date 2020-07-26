class Solution {
    private int ans;
    private int n, m;
    private void dfs(int[] nums, int i, int cntSubarrays, int curSum, int curMax) {
        if (i == n && cntSubarrays == m) {
            ans = Math.min(ans, curMax);
            return;
        }
        if (i == n) {
            return;
        }
        if (i > 0) {
            dfs(nums, i + 1, cntSubarrays, curSum + nums[i], Math.max(curMax, curSum + nums[i]));
        }
        if (cntSubarrays < m) {
            dfs(nums, i + 1, cntSubarrays + 1, nums[i], Math.max(curMax, nums[i]));
        }
    }
    public int splitArray(int[] nums, int M) {
        ans = Integer.MAX_VALUE;
        n = nums.length;
        m = M;
        dfs(nums, 0, 0, 0, 0);
        return ans;
    }
}

class Solution {
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        int[][] dp = new int[len][m + 1];
        for(int[] line: dp)
            Arrays.fill(line, Integer.MAX_VALUE);
        int[] sub = new int[len];
        sub[0] = nums[0];
        for(int i = 1; i < len; i++)
            sub[i] = sub[i - 1] + nums[i];
        for(int i = 0; i < len; i++)
            dp[i][1] = sub[i];
        for(int i = 2; i <= m; i++){
            for(int j = i - 1; j < len; j++){
                for(int k = 0; k < j;k++){
                    dp[j][i] = Math.min(dp[j][i], Math.max(dp[k][i - 1], sub[j] - sub[k]));
                }
            }
        }
        return dp[len - 1][m];
    }
}