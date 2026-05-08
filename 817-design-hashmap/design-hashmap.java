class MyHashMap {
    class Node{
        int key, value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }


    int SIZE = 1001;
    List<Node>[] map;

    public MyHashMap() {
        map = new ArrayList[SIZE];
    }
    
    public void put(int key, int value) {
        int i = hash(key);

        if(map[i] == null){
            map[i] = new ArrayList<>();
        }
        
        for(Node node: map[i]){
            if(node.key == key){
                node.value = value;
                return;
            }
        }

        map[i].add(new Node(key, value));

    }
    
    public int get(int key) {
        int i = hash(key);
        if(map[i] == null) return -1;
        for(Node node: map[i]){
            if(node.key == key){
                return node.value;
            }
        }
        return -1;

    }
    
    public void remove(int key) {
        int i = hash(key);
        if(map[i] == null) return;
        for(Node node: map[i]){
            if(node.key == key){
                map[i].remove(node);
                break;
            }
        }
    }

    public int hash(int key){
        return key%SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */