class Solution{
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node){
        if(node == null) return null;
        Node copy = new Node(node.val, new ArrayList<>());
        map.put(copy.val, copy);
        for(Node n: node.neighbors){
            if(map.containsKey(n.val))  copy.neighbors.add(map.get(n.val));
            else    copy.neighbors.add(cloneGraph(n));
        }
        return copy;
    }
}