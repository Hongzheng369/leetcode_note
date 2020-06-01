/*
https://www.cnblogs.com/lz87/p/11565654.html

Minimum Knight Moves
In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
Example 1:

Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]
Example 2:

Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]


O(x * y) runtime and space
*/

class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        int MAXN = 310, steps = 0;
        int[] dx = {-2,-1,1,2,2,1,-1,-2};
        int[] dy = {1,2,2,1,-1,-2,-2,-1};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[MAXN][MAXN];
        q.add(new int[]{0,0});        
        visited[0][0] = true;
        
        while(q.size() > 0) {
            int sz = q.size();
            for(int i = 0; i < sz; i++) {
                int[] curr = q.poll();
                if(curr[0] == x && curr[1] == y) {
                    return steps;
                }
                for(int j = 0; j < 8; j++) {
                    int x1 = curr[0] + dx[j];
                    int y1 = curr[1] + dy[j];
                    if(x1 < 0 || y1 < 0 || x1 >= MAXN || y1 >= MAXN) {
                        continue;
                    }
                    if(!visited[x1][y1]) {
                        visited[x1][y1] = true;
                        q.add(new int[]{x1, y1});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}