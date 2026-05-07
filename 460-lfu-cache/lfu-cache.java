class LFUCache {
    class Node{
        int key, value, freq;
        Node prev, next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            freq = 1;
            prev = null;
            next = null;
        }

        public void setValue(int value){
            this.value = value;
            freq += 1;
        }

        public int getValue(){
            freq+=1;
            return value;
        }
    }

    class DoublyLinkedList{
        //LRU always on left
        Node left, right;
        int size;

        public DoublyLinkedList(){
            left = new Node(0,0);
            right = new Node(0,0);
            left.next = right;
            right.prev = left;
            size = 0;
        }

        public void pushRight(Node node){
            Node prev = right.prev;
            prev.next = node;
            node.prev = prev;

            right.prev = node;
            node.next = right;
            size++;
        }

        public void pop(Node node){
            Node prev = node.prev, next = node.next;
            prev.next = next;
            next.prev = prev;
            node.prev = null;
            node.next = null;
            size--;
        }

        public Node popLeft(){
            //LRU
            Node node = this.left.next;
            pop(node);
            return node;
        }
    }

    Map<Integer, Node> map;
    Map<Integer, DoublyLinkedList> freqMap;
    int minFreq, capacity;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node curr = map.get(key);
        if(curr == null) return -1;
        freqMap.get(curr.freq).pop(curr);
        if (curr.freq == minFreq && freqMap.get(minFreq).size == 0) {
            minFreq++;
        }
        freqMap.computeIfAbsent(curr.freq+1, k-> new DoublyLinkedList()).pushRight(curr);
        return curr.getValue();
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            int freq = node.freq;

            freqMap.get(freq).pop(node);
            if(freq == minFreq && freqMap.get(freq).size == 0){
                minFreq++;
            }

            node.setValue(value);
            freqMap.computeIfAbsent(freq+1, k->new DoublyLinkedList()).pushRight(node);
            return;
        }

        if(map.size() == capacity){
            Node toRemove = freqMap.get(minFreq).popLeft();
            map.remove(toRemove.key);
        }
        
        
        Node node = new Node(key, value);
        map.put(key, node);
        freqMap.computeIfAbsent(1, k-> new DoublyLinkedList()).pushRight(node);
        minFreq = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */