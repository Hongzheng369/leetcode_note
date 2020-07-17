/* 
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2){
                return distance(p2) - distance(p1);
            }
        });
        for(int[] p: points){
            pq.add(p);
            if(pq.size() > K){
                pq.poll();
            }
        }
        return pq.toArray(new int[K][2]);
    }
    
    public int distance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}