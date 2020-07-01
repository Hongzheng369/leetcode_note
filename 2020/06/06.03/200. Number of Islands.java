class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length- 1, n =grid[0].length -1;
        int numOfIslands = 0;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(grid[i][j] == '1'){
                 numOfIslands++;
                 dfs(grid, i, j);
               
                }
                
            }
        }
        return numOfIslands;
    }
    public void dfs(char[][] grid, int i, int j){
        if(i<0 || j <0 || i>=grid.length || j>=grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j - 1);
    }
}