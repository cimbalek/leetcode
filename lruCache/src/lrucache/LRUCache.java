package lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private final Map<Integer, Integer> items;
    private final int capacity;

    public LRUCache(int size) {
        this.items = new LinkedHashMap<Integer, Integer>(size, 1.0f, true) {

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size()>capacity;
            }
        };
        this.capacity = size;
    }

    

    public int get(int key) {
        return items.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        items.put(key, value);
    }
    
}
