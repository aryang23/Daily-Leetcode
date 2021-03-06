class RandomizedSet {

    /** Initialize your data structure here. */
    HashMap<Integer, Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)==false)
            return false;
        
        int ind = map.get(val);
        Collections.swap(list, ind, list.size()-1);
        int swappedWith = list.get(ind);
        map.put(swappedWith, ind);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
