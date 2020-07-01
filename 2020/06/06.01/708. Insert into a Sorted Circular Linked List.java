/*
题目：

Given a node from a Circular Linked List which is sorted in ascending order, write a function to insert a value insertVal into the list such that it remains a sorted circular list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the circular list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the circular list should remain sorted.

If the list is empty (i.e., given node is null), you should create a new single circular list and return the reference to that single node. Otherwise, you should return the original given node.

 

Example 1:


 

Input: head = [3,4,1], insertVal = 2
Output: [3,4,1,2]
Explanation: In the figure above, there is a sorted circular list of three elements. You are given a reference to the node with value 3, and we need to insert 2 into the list. The new node should be inserted between node 1 and node 3. After the insertion, the list should look like this, and we should still return node 3.



Example 2:

Input: head = [], insertVal = 1
Output: [1]
Explanation: The list is empty (given head is null). We create a new single circular list and return the reference to that single node.
Example 3:

Input: head = [1], insertVal = 0
Output: [1,0]
Constraints:

0 <= Number of Nodes <= 5 * 10^4
-10^6 <= Node.val <= 10^6
-10^6 <= insertVal <= 10^6
题解：

The insertion position is within 3 condition,

1. cur go through a round back to head.

2.  cur.val <= insertVal <= cur.next.val

3. insertVal super max or insertVal super small, insert into the fall down position.

Note: Pay attention to corner case, head == null. DO NOT forget to have cur = cur.next in while loop.

Time Complexity: O(n). n = circular length.

Space: O(1).
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        Node res = new Node(insertVal);
        if(head == null){
            res.next = res;
            return res;
        }

        Node cur = head;
        while(cur.next != head
              && !((cur.val <= insertVal && insertVal <= cur.next.val)
                   || (cur.val > cur.next.val && (cur.next.val > insertVal || cur.val < insertVal)))){
            cur = cur.next;
        }

        res.next = cur.next;
        cur.next = res;
        return head;
    }
}