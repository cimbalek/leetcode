package lrucache;


public class CacheApp {

    public static void main(String[] args) {
        LRUCache cache = new  LRUCache(5);
        
        System.out.println(cache.get(3));
        cache.set(3, 7);
        System.out.println(cache.get(3));
        cache.set(1, 9);
        cache.set(4, 6);
        cache.set(5, 5);
        cache.set(1, 14);
        cache.set(8, 2);
        System.out.println(cache.get(3));
        cache.set(2, 8);
        cache.set(6, 4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
    }
    
}
