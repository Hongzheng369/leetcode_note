/* You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents a different task. Tasks could be done without the original order of the array. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

You need to return the least number of units of times that the CPU will take to finish all the given tasks. 
Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
*/
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