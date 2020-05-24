class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        // Brute force TLE
        /*
            Find all the subsets of nums1 and nums2
            and go over each combindations (lengths are equal and find the max dot product)
            and improve with memoization.
            
            T: O(2^n) S: O(2^n) - all combinations. nCn
        */
        
        List<List<Integer>> nums1Subsets = getSubset(nums1);
        List<List<Integer>> nums2Subsets = getSubset(nums2);
        
        int result=Integer.MIN_VALUE;
        for(List<Integer> subset1:nums1Subsets) {
            for(List<Integer> subset2:nums2Subsets) {
                if(subset1.size()!=0 && subset1.size()==subset2.size()) {
                    
                    int product=0;
                    for(int i=0;i<subset1.size();++i) {
                        product+=subset1.get(i) * subset2.get(i);
                    }
                    
                    result=Math.max(product, result);
                }
            }
        }
        
        return result;
    }
    
    
    private List<List<Integer>> getSubset(int[] nums) { 
        List<List<Integer>> res = new ArrayList();
        helper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void helper(int[] nums, int idx, List<Integer> subset, List<List<Integer>> res) {
        
        if(idx==nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        
        subset.add(nums[idx]);
        helper(nums, idx+1, subset, res);
        subset.remove(subset.size()-1);
        helper(nums, idx+1, subset, res);
    }
    
}