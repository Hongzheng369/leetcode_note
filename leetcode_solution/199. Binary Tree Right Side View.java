/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)    return res;
        helper(root, res, 0);
        //helper(root.right, res, 0)
        return res;
    }
    
    public void helper(TreeNode node, List<Integer> res, int curDepth){
        if(node == null)    return;
        if(curDepth == res.size())  res.add(node.val);
        helper(node.right, res, curDepth + 1);
        helper(node.left, res, curDepth + 1);
    }
}