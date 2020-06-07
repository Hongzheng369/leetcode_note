class Solution {
    public int longestArithSeqLength(int[] A) {
        Integer max = 1;
        
        for(int i = 0;i<A.length;i++) {
            max = Math.max(max, helper(i, A, null));
        }
        return max;
    }
    
    private int helper(int index, int[] A, Integer diff) {
        if(index >= A.length) return 0;
        Integer max = 0;
        if(diff == null) {
            for(int j = index+1;j<A.length;j++) {
                max = Math.max(max, helper(j, A, A[j]-A[index]));
            }
        } else {
            for(int j = index+1; j<A.length;j++) {
                if(A[j]-A[index] == diff) {
                    max = Math.max(max, helper(j, A, diff));
                }
            }
        }
        return 1+max;
    }
}

class Solution {
    public int longestArithSeqLength(int[] A) {
        int res = 2, n = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < A.length; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int d = A[j] - A[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }
}