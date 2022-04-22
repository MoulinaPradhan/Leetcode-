class MyHashMap {

    ArrayList<int[]> al;
    /** Initialize your data structure here. */
    public MyHashMap() {
        al=new ArrayList<>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        for(int i=0;i<al.size();i++)
        {
            int[] a=al.get(i);
            if(a[0]==key){a[1]=value;return;}
        }
        int[] a=new int[2];
        a[0]=key;
        a[1]=value;
        al.add(a);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for(int i=0;i<al.size();i++)
        {
            int[] a=al.get(i);
            if(a[0]==key)return a[1];
        }
        return -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        for(int i=0;i<al.size();i++)
        {
            int[] a=al.get(i);
            if(a[0]==key)al.remove(al.get(i));
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */