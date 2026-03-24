class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
    Map<Integer, Node> map;
    Node left;
    Node right;
    int cap;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            remove(curr);
            put(key, curr.val);
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        Node curr = new Node(key, value);
        insert(curr);
        map.put(key, curr);

        if(map.size() > cap){
            remove(left.next);
        }
    }

    public void insert(Node node){
        Node prev = right.prev;
        prev.next = node;

        node.prev = prev;
        node.next = right;

        right.prev = node;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        map.remove(node.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */