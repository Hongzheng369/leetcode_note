class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++)
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        int[] vis = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(findCircle(i, vis, graph))
                return false;
        }
        return true;
    }
    public boolean findCircle(int node, int[] vis, List<List<Integer>> graph){
        if(vis[node] == 1)
            return true;
        if(vis[node] == 2)
            return false;
        vis[node] = 1;
        for(int next: graph.get(node)){
            if(findCircle(next, vis, graph))
                return true;
        }
        vis[node] = 2;
        return false;
    }
}