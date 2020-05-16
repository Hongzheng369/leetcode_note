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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res, int curDepth){
        if(root == null)
            return;
        if(curDepth == res.size())
            res.add(root.val);
        helper(root.right, res, curDepth + 1);
        helper(root.left, res, curDepth + 1);
    }
}