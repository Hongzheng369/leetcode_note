/*
The time can be improved by not using TreeMap. We can calculate the min and max order of the tree first. We know that there should not be any gap between any indices.
*/

public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if(root==null){
        return result;
    }
 
    int[] mm = new int[2];
    getMinMax(root, mm, 0);
 
    int len = mm[1]-mm[0]+1;
 
    for(int i=0; i<len; i++){
        result.add(new ArrayList<Integer>());
    }
 
    LinkedList<TreeNode> q1 = new LinkedList<>();
    LinkedList<Integer> q2 = new LinkedList<>();
 
    q1.offer(root);
    q2.offer(0);
 
    while(!q1.isEmpty()){
        TreeNode h = q1.poll();
        int order = q2.poll();
 
        result.get(order-mm[0]).add(h.val);
 
        if(h.left!=null){
            q1.offer(h.left);
            q2.offer(order-1);
        }
        if(h.right!=null){
            q1.offer(h.right);
            q2.offer(order+1);
        }
    }
 
    return result;
}
 
 
private void getMinMax(TreeNode node, int[] mm, int order){
    if(node == null){
        return;
    }
 
    mm[0] = Math.min(mm[0], order);
    mm[1] = Math.max(mm[1], order);
 
    getMinMax(node.left, mm, order-1);
    getMinMax(node.right, mm, order+1);
}