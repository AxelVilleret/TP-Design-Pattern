package fr.ensim.dp.cache;

import java.util.*;

import fr.ensim.dp.cache.filter.EmptyFilterCache;
import fr.ensim.dp.cache.filter.IFilterCache;

public class MemoryCache implements ICache {

    private IFilterCache filterCache = new EmptyFilterCache();

    private static MemoryCache singleton = new MemoryCache();

    private Map<String, byte[]> cache = new HashMap<>();

    private MemoryCache() {}

    public static MemoryCache getInstance() {
        return singleton;
    }

    @Override
    public long size() {
        long size = 0;   
        for (Map.Entry<String, byte[]> m : cache.entrySet()) {
            size += m.getValue().length;
        }
        return size;
    }

    @Override
    public boolean add(String key, byte[] buf) {
        if (!cache.containsKey(key)) {
            cache.put(key, filterCache.doAdd(key, buf));
            return true;
        }
        return false;
    }

    @Override
    public byte[] retreive(String key) {
        return filterCache.doRetreive(key, cache.get(key));
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public IFilterCache setFilterCache(IFilterCache filterCache) {
        if (filterCache == null)
            this.filterCache = new EmptyFilterCache();
        else 
            this.filterCache = filterCache;
        return this.filterCache;
    }


}
