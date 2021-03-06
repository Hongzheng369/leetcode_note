class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for(int i = 0;i < nums.length; i++){
            int[] dp1 = Arrays.copyOf(dp, 3);
            for(int j = 0; j < 3; j++){
                int cur = nums[i] + dp[j];
                dp1[cur % 3] = Math.max(dp1[cur % 3], cur);
            }
            dp = dp1;
        }
        return dp[0];
    }
}