/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
     // Map<Integer, Node> map = new HashMap<>();
        if(node == null) return null;
        Node copy = new Node(node.val, new ArrayList<>());
        map.put(copy.val, copy);

        for(Node n: node.neighbors){
            if(map.containsKey(n.val)) {
                copy.neighbors.add(map.get(n.val));
            } else {
                copy.neighbors.add(cloneGraph(n));
            }
        }
        
        return copy;
    }
}