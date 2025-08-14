import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheMain {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

}

class LRUCache {

    Map<Integer, Integer> map;
    LinkedList<Integer> list;
    int capacity;

    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();
    }

    public int get(int num) {
        if (!map.containsKey(num))
            return -1;

        int res = map.get(num);
        int ind = list.indexOf(num);
        int val = list.remove(ind);
        list.add(0, val);
        return res;
    }

    public void put(int key, int value) {
        if (map.size() >= capacity) {
            int temp = list.removeLast();
            map.remove(temp);
        }

        map.put(key, value);
        list.add(0,key);
    }

}
