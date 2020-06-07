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