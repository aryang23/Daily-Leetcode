class MyHashSet {
    HashSet<Integer> set;
    public MyHashSet() {
        set = new HashSet<>();
    }
    
    public void add(int key) {
        set.add(key);
    }
    
    public void remove(int key) {
        set.remove(key);
    }
    
    public boolean contains(int key) {
        if(set.contains(key))
            return true;
        return false;
    }
}
