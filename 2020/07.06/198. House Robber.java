class Solution{
    for(int i = 1; i < N; i++){
        dp[i][0] = dp[i - 1] + val[i];
        dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1])
    }
    ans = Math.max(dp[N][0], dp[N][1]);
}