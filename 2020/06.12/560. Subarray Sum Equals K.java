class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(preSum.containsKey(sum - k))
                res += preSum.get(sum - k);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}