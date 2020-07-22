 class Solution {

    


    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        Arrays.fill(res, 0);
        Node root = null;
        for(int i = nums.length - 1; i >= 0; i--){
            root = createNode(root, new Node(nums[i]), res, i);
        }
        return Arrays.asList(res);
    }
    
    public Node createNode(Node root, Node node, Integer[] res, int i){
        if(root == null){
            root = node;
            return root;
        }
        if(root.val >= node.val){
            root.count++;
            root.left = createNode(root.left, node, res, i);
        }else{
            res[i] += 1 + root.count;
            root.right = createNode(root.right, node, res, i);
        }
        return root;
    }
 }

class Node{
        Node left;
        Node right;
        int val;
        int count;
    
    public Node(int val){
        this.val = val;
    }
}
