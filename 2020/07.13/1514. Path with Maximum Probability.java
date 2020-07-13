class Solution{
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end){
        Map<Integer, List<double[]>> graph = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(new double[] {edge[1], succProb[i]});
            graph.get(edge[1]).add(new double[] {edge[0], succProb[i]});            
        }
        double[] vis = new double[n];
        vis[start] = 1.0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int parent = queue.poll();
            if(!graph.containsKey(parent))  continue;
            for(double[] child: graph.get(parent)){
                int childName = (int) child[0];
                double prob = vis[parent] * child[1];
                if(vis[childName] >= prob)  continue;
                queue.offer(childName);
                vis[childName] = prob; 
            }
        }
        return vis[end];
    }
}