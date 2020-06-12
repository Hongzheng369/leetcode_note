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
        if(nums.length == 0) return 0;
        int res = 0;
        int[] sum = new int[nums.length + 1];
        for(int i = 1; i <=nums.length; i++)
            sum[i] = sum[i-1] + nums[i-1];
        for(int start = 0; start < nums.length; start++){
            for(int end = start + 1; end <= nums.length; end++){
                if(sum[end] - sum[start] == k)
                    res++;
            }
        }
        return res;
    }
}


