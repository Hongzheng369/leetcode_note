class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length == 0 || nums.length == 1) return false;
        if(k == 0){
            for(int i = 1; i < nums.length; i++){
                if(nums[i - 1] == 0 && nums[i] == 0)    return true;
            }
            return false;
        }
        for(int i = 0; i < nums.length; i++){
            int sum = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                sum += nums[j];
                //if(k == 0 && sum == 0) return true;  
                if(sum % k == 0) return true;
            }
        }
        return false;
    }
}

class Solution {
    public boolean checkSubarraySum(int[] nums, int k){
        if(nums.length < 2) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int curSum = 0;
        for(int i = 0; i < nums.length; i++){
            curSum += nums[i];
            if(k != 0)  curSum = curSum % k;
            if(map.containsKey(curSum)){
                if(i - map.get(curSum) > 1) return true;
            }else
                map.put(curSum, i);
        }
        return false;
    }
}