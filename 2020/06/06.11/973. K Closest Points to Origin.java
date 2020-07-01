class Solution {
    public int[][] kClosest(int[][] points, int K) {
		Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				return distance(p2) - distance(p1);
			}
		});
		for (int[] p : points) {
			pq.add(p);
			if (pq.size() > K)
				pq.poll();
		}
		return pq.toArray(new int[K][2]);
    }
    private int distance(int[] point) {
    	return point[0] * point[0] + point[1] * point[1];
     }
}