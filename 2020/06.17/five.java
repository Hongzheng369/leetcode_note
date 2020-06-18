public static void main(String args[]){


}

public static int helper(String s){
    int len = s.length();
    dp[0] = s.charAt(0) == 'F'? 1:0;
    for(int i = 1; i < len; i++){
        dp[i] = s,charAt(i) == 'F'? dp[i - 1] + 1: dp[i - 1];
    }
    for(int i = 0; i < n; i++){
        for(int j = 0; j < len; j++){
            dp[j] = dp[j]<= j? dp[j] + 1: dp[j] - 1;
        }
    }
    return dp[len - 1];
}