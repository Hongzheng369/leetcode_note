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
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean nullHasBeenFound = false;
        while(!q.isEmpty()) {

            TreeNode current = q.remove();        

            if(current == null) {
                nullHasBeenFound = true;
                continue;
            } else if(nullHasBeenFound) {
                return false;
            }

            q.add(current.left);                
            q.add(current.right); 
        }
        return true;
    }
}