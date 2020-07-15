
// Author: Huahua
class Solution {
  private List<Integer> ids;
  
  public int widthOfBinaryTree(TreeNode root) {
    this.ids = new ArrayList<Integer>();
    return dfs(root, 0, 0);
  }
  
  private int dfs(TreeNode root, int d, int id) {
    if (root == null) return 0;
    if (ids.size() == d) ids.add(id);
    return Math.max(id - ids.get(d) + 1, 
             Math.max(this.dfs(root.left, d + 1, (id - ids.get(d)) * 2),
                      this.dfs(root.right, d + 1, (id - ids.get(d)) * 2 + 1)));
  }
}