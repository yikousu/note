package com.algorithm.intv;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author hac
 * @date 2025/4/6 17:05
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);// accessOrder = true，按访问顺序排序
        this.capacity = capacity;
    }

    /**
     * removeEldestEntry(Map.Entry<K, V> eldest)：这个方法在 LinkedHashMap 中是一个钩子方法（hook method）
     * 当每次插入新的元素时，LinkedHashMap 会调用这个方法判断是否需要移除最旧的元素（即LRU 淘汰策略）
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当当前缓存的大小超过了容量限制时，返回 true，表示需要移除最旧的元素
        return size() > capacity;
    }

    public V get(Object key) {
        return super.get(key);
    }

    public V put(K key, V value) {
        return super.put(key, value);
    }

    // 测试用例
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.get(1);           // 访问1，1变成最近使用
        cache.put(4, "D");      // 淘汰最久未使用的2
        System.out.println(cache.keySet()); // 输出 [3, 1, 4]
    }
}
