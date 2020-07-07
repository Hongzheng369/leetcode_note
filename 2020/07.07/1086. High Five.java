/*
Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
Output: [[1,87],[2,88]]
Explanation: 
The average of the student with id = 1 is 87.
The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
————————————————
版权声明：本文为CSDN博主「YuanTheCoder」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/YuanTheCoder/java/article/details/95485292
*/

class Solution {
    public int[][] highFive(int[][] items) {   
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();        
        for(int[] item : items){
            int id = item[0];
            int score = item[1];
            
            if(!map.containsKey(id)){
                PriorityQueue<Integer> pq = new PriorityQueue<Integer>(5);
                pq.offer(score);
                map.put(id, pq);
            }else{
                PriorityQueue<Integer> pq = map.get(id);
                pq.offer(score);
                if(pq.size() > 5){
                    pq.poll();
                }
                map.put(id, pq);
            }
        }
        
        int index = 0;       
        int[][] res = new int[map.size()][2];        
        for(int id : map.keySet()){
           res[index][0] = id;       
           PriorityQueue<Integer> pq = map.get(id);
           int sum = 0;
           int size = pq.size();
           
           while(!pq.isEmpty()){
               sum+= pq.poll();
           }
           res[index][1] = sum/size;
           index++;           
       }     
        return res;
    }
