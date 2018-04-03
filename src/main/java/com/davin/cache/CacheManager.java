package com.davin.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheManager<T> {
    private Map<String,T> cache = new ConcurrentHashMap<String, T>();

    public T getValue(Object key){
        return cache.get(key);
    }

    public void addOrUpdateCache(String key,T o){
        cache.put(key,o);
    }

    public void evictCache(String key){
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
    }

    public void evict(){
        cache.clear();
    }
}
