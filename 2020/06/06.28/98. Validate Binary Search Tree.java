/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root){
        return helper(root, null, null);
    }
    public boolean helper(TreeNode root, Integer low, Integer high){
        if(root == null)    return true;
        int val = root.val;
        if(low != null && val <= low)   return false;
        if(high != null && val >= high) return false;
        if(!helper(root.left, low, val))    return false;
        if(!helper(root.right, val, high))  return false;
        return true;
    }
}