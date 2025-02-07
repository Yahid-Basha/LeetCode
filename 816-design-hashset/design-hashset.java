class MyHashSet {
    int[] set;
    public MyHashSet() {
        set = new int[1000000];
        Arrays.fill(set, -1);
    }
    
    public int getHash(int key){
        return key%1000000; 
    }

    public void add(int key) {
        set[getHash(key)] = key;
    }
    
    public void remove(int key) {
        set[getHash(key)] = -1;
    }
    
    public boolean contains(int key) {
        if(set[getHash(key)] == key){
            return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */