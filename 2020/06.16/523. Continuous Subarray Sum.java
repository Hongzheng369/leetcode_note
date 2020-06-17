class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int curSum = 0;
        for(int i = 0; i < nums.length; i++){
            curSum += nums[i];
            if(k != 0)  curSum %= k;
            if(map.containsKey(curSum)){
                if(i - map.get(curSum) > 1) return true;
            }else
                map.put(curSum, i);
        }
        return false;
    }
}