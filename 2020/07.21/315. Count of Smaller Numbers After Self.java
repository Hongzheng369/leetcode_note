/* You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0] 
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
 */

 class Solution {
    class Node{
        Node left;
        Node right;
        int val;
        int count;
    }
    public Node(int val){
        this.val = val;
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

    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        Arrays.fill(res, 0);
        Node root = null;
        for(int i = nums.length - 1; i >= 0; i--){
            root = createNode(root, new Node(nums[i]), res, i);
        }
        return Arrays.asList(res);
    }
}