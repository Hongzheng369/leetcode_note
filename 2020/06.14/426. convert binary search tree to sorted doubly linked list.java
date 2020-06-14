/*
Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.

Let's take the following BST as an example, it may help you understand the problem better:


把一个二叉搜索树转换成一个排序的双向链表

解题思路分析
1. 二叉搜索树， 如果用in order遍历的话，那么就是按照顺序遍历的
2. 所以， 只要在遍历的时候记住prev, 然后把prev和当前节点连起来就好了

*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    private Node head;
    private Node tail;
    private Node prev;
    public Node treeToDoublyList(Node root) {
        if(null == root) return null;
        
        tail = head = prev = null;
        dfs(root);
        tail.right = head;
        head.left = tail;
        
        return head;
    }
    void dfs(Node node) {
        if(null == node) return;
        dfs(node.left);
        
        Node cur = new Node(node.val);
        if(null == head) {
            head = cur;
        }
        if(null != prev) {
            prev.right = cur;
            cur.left = prev;
        }
        prev = cur;
        tail = cur;
        dfs(node.right);
    }
}