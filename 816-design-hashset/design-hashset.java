class MyHashSet {
    int SIZE = 1009;
    List<Integer>[] list;

    public MyHashSet() {
        list = new ArrayList[SIZE];
    }
    
    public void add(int key) {
        int hash = key%SIZE;
        if(list[hash] == null){
            list[hash] = new ArrayList<>();
        }
        if(!list[hash].contains(key)) list[hash].add(key);
    }
    
    public void remove(int key) {
        int hash = key%SIZE;
        if(list[hash] != null && list[hash].contains(key)){
            list[hash].remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int hash = key%SIZE;
        if(list[hash] != null && list[hash].contains(key))
            return true;
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