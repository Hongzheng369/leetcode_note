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

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node head = null, pre = null;
        inorder(root, pre, head);
        pre.right = head;
        head.left = pre;
        return head;
    }
    void inorder(Node node, Node pre, Node head) {
        if (node == null) return;
        inorder(node.left, pre, head);
        if (head == null) {
            head = node;
            pre = node;
        } else {
            pre.right = node;
            node.left = pre;
            pre = node;
        }
        inorder(node.right, pre, head);
    }
}