class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for(char task: tasks)   frequencies[task - 'A']++;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int frequency: frequencies){
            if(frequency != 0)  pq.add(frequency);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int time = 0, tasksRemaining = tasks.length;
        while(tasksRemaining > 0){
            Integer prev = map.get(time);
            if(prev != null) pq.add(prev);
            Integer cur = pq.poll();
            if(cur != null) tasksRemaining--;
            if(cur != null && --cur > 0)    map.put(time + n + 1, cur);
            time++;
        }
        return time;
    }
}