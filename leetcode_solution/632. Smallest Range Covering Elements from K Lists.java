class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int leftRange = 0;
        int rightRange = Integer.MAX_VALUE;
        int minRange = rightRange - leftRange;
        
        int max = Integer.MIN_VALUE;
        int size = nums.size();
        int[] ptrs = new int[size];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer idx1, Integer idx2){
                return nums.get(idx1).get(ptrs[idx1]) - nums.get(idx2).get(ptrs[idx2]);
            }
        });
        for(int i = 0; i < ptrs.length; i++){
            queue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        while(true){
            int minIndex = queue.poll();
            int curRange = max - nums.get(minIndex).get(ptrs[minIndex]);
            if(curRange < minRange){
                minRange = curRange;
                leftRange = nums.get(minIndex).get(ptrs[minIndex]);
                rightRange = max;
            }
            ptrs[minIndex]++;
            if(ptrs[minIndex] == nums.get(minIndex).size()){
                break;
            }
            queue.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(ptrs[minIndex]));
        }
        int[] res = new int[2];
        res[0] = leftRange;
        res[1] = rightRange;
        return res;
    }
}