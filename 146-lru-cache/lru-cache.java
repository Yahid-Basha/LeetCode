class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node left, right; // sentinels

    class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        left = new Node(0, 0);   // LRU sentinel
        right = new Node(0, 0);  // MRU sentinel
        left.next = right;
        right.prev = left;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertMRU(Node node) {
        node.prev = right.prev;
        node.next = right;
        right.prev.next = node;
        right.prev = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertMRU(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        Node node = new Node(key, value);
        map.put(key, node);
        insertMRU(node);
        if (map.size() > capacity) {
            Node lru = left.next;  // evict LRU
            remove(lru);
            map.remove(lru.key);
        }
    }
}