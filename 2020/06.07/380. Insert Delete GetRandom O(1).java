class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
       // rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        list.set(map.get(val), list.get(list.size() - 1));
        map.put(list.get(list.size() - 1), map.get(val));
        map.remove(val);
        list.remove(list.size() - 1);     
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        //int res = 0;
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */