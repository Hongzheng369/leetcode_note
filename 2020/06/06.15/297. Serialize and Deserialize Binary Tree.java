/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private final String split = ",";
    private final String NN = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        return sb.toString();
    }
    public void buildString(StringBuilder sb, TreeNode root){
        if(root == null) sb.append(NN).append(split);
        else{
        sb.append(root.val).append(split);
        buildString(sb, root.left);
        buildString(sb, root.right);   
        }

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(split)));
        return buildTree(nodes);
    }
    public TreeNode buildTree(Deque<String> nodes){
        String val = nodes.remove();
        if(val.equals(NN)) return null;
        else{
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));