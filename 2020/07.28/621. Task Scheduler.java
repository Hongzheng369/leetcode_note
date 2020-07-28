/* You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents a different task. Tasks could be done without the original order of the array. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

You need to return the least number of units of times that the CPU will take to finish all the given tasks. */
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