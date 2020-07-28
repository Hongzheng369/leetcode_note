class Solution {
    private int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if(m == 0)    return 0;
        int n = matrix[0].length;
        
        
        int res = Integer.MIN_VALUE;
        memo = new int[m][n];
        for(int[] line: memo)   Arrays.fill(line, 0);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res, dfs(matrix, i, j, Integer.MIN_VALUE)); 
            }
        }
        return res;
    }
    
    public int dfs(int[][] matrix, int i, int j, int value){
        if(i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0)   return 0;
        if(matrix[i][j] <= value)   return 0;
        if(memo[i][j] != 0)   return memo[i][j];
        memo[i][j]++;
        int up = dfs(matrix, i - 1, j, matrix[i][j]);
        int down = dfs(matrix, i + 1, j, matrix[i][j]);
        int left = dfs(matrix, i, j - 1, matrix[i][j]);
        int right = dfs(matrix, i, j + 1, matrix[i][j]);
        memo[i][j] = Math.max(memo[i][j], Math.max(Math.max(up, right), Math.max(down, left)) + 1);
        return memo[i][j];
    }
}