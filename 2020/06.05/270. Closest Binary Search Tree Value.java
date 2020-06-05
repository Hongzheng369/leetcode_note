/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4
 

这道题让我们找一个二分搜索数的跟给定值最接近的一个节点值，由于是二分搜索树，
所以博主最先想到用中序遍历来做，一个一个的比较，维护一个最小值，不停的更新，
实际上这种方法并没有提高效率，用其他的遍历方法也可以，参见代码如下：
*/