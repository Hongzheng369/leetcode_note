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
    Map<TreeNode, Integer> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        find(root, target);
        search(root, 0, K, res);
        return res;
    }

    private void find(TreeNode root, TreeNode target) {
        if (root == null) {
            return;
        }

        if (root == target) {
            map.put(root, 0);
            return;
        }

        find(root.left, target);
        if (map.containsKey(root.left)) {
            map.put(root, map.get(root.left) + 1);
            return;
        }

        find(root.right, target); 
        if (map.containsKey(root.right)) {
            map.put(root, map.get(root.right) + 1);
            return;
        }
        return;
    }

    public void search(TreeNode root, int dis, int K, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (map.containsKey(root)) {
            dis = map.get(root);
        }

        if (dis == K) {
            res.add(root.val);
        }

        search(root.left, dis + 1, K, res);
        search(root.right, dis + 1, K, res);
    }
}
