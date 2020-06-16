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
/** Key point: if we can find any two subarray of prefix sum have same mod value, then their difference MUST be
 * divisible by k. So we can use a map to store mod value of each prefix sum in map, with its index. Then check
 * if map contains the same mod value with size > 2 when we have new mod value in every iteration */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        // corner case: if the very first subarray with first two numbers in array could form the result, we need to 
        // put mod value 0 and index -1 to make it as a true case
        map.put(0, -1);
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];

            // corner case: k CANNOT be 0 when we use a number mod k
            if (k != 0) {
                curSum = curSum % k;
            }
            if (map.containsKey(curSum)) {
                if (i - map.get(curSum) > 1) {
                    return true;
                }
            }
            else {
                map.put(curSum, i);
            }
        }
        return false;
    }
}