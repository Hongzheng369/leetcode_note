/* 
Input:nums = [1,1,1], k = 2
Output: 2


 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int res = 0;
        //int sum = nums[0];
        for(int start = 0; start < nums.length; start++){
            for(int end = start + 1; end <= nums.length; end++){
                //if(sum == k)
                int sum = 0;
                for(int i = start; i < end; i++)
                    sum += nums[i];
                if(sum == k)
                    res++;
            }
        }
        return res;
    }
}

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