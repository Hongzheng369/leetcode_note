import java.util.*;
class LRUCache {
    private Hashtable<Integer, DNode>  map = new Hashtable<>();
    private int count;
    private int capacity;
    private DNode head, tail;
    
    class DNode{
        DNode pre;
        DNode post;
        int key, val;
    }
    
    private void addNode(DNode node){
        node.pre = head;
        node.post = head.post;
        
        head.post.pre = node;
        head.post = node;
    }
    private void removeNode(DNode node){
        DNode pre = node.pre;
        DNode post = node.post;
        pre.post = post;
        post.pre = pre;
    }
    private void moveToHead(DNode node){
        this.removeNode(node);
        this.addNode(node);
    }
    private DNode popTail(){
        DNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
    
    
    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        
        head= new DNode();
        head.pre = null;
        tail = new DNode();
        tail.post = null;
        
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DNode node = map.get(key);
        if(node == null){
            return -1;
            
        }
        this.moveToHead(node);
        return node.val;
        
    }
    
    public void put(int key, int val) {
        DNode node = map.get(key);
        if(node == null){
            DNode  newNode = new DNode();
            newNode.key = key;
            newNode.val = val;
            this.map.put(key, newNode);
            this.addNode(newNode);
            count++;
            if(count > capacity){
                DNode tail = this.popTail();
                this.map.remove(tail.key);
                count--;
            }
        }else{
            node.val = val;
            this.moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */