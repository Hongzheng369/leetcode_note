/*
Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.

Example 1:

Input: A = [4,7,9,10], K = 1
Output: 5
Explanation: 
The first missing number is 5.
Example 2:

Input: A = [4,7,9,10], K = 3
Output: 8
Explanation: 
The missing numbers are [5,6,8,...], hence the third missing number is 8.
Example 3:

Input: A = [1,2,4], K = 3
Output: 6
Explanation: 
The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
Note:

1 <= A.length <= 50000
1 <= A[i] <= 1e7
1 <= K <= 1e8
题解：

If the missing numbers count of the whole array < k, then missing number must be after nums[n-1].  res = nums[n-1] + missingCount.

Otherwise, need to find out the starting index to calculate the missing number.

Use binary search to have mid as candidate. 

If missing count < k, then must fall on the right side. l = mid + 1.

Time Complexity: O(logn). n = nums.length.

Space: O(1).
*/
 
 
 class Solution {
      public int missingElement(int[] nums, int k) {
          int n = nums.length;
          if(nums[n - 1] - nums[0] - (n - 1 - 0) < k){
              return nums[n - 1] + k - missCount(nums, n - 1);
          }
          
          int l = 0;
          int r = n - 1;
         
         while(l < r){
             int mid = l + (r - l) / 2;
             if(missCount(nums, mid) < k){
                 l = mid + 1;
             }else{
                 r = mid;
             }
         }
         
         return nums[l - 1] + k - missCount(nums, l - 1);
     }
     
     private int missCount(int [] nums, int mid){
         return nums[mid] - nums[0] - mid;
     }
 }