package fr.ensim.dp.cache;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import fr.ensim.dp.cache.filter.EmptyFilterCache;
import fr.ensim.dp.cache.filter.IFilterCache;
import fr.ensim.dp.util.FileUtil;

public class DiskCache implements ICache {

    private IFilterCache filterCache = new EmptyFilterCache();

    private static Map<String, DiskCache> disks = new HashMap<>();

    public static DiskCache getInstance(String type) {
        if (!DiskCache.disks.containsKey(type)) {
            DiskCache.disks.put(type, new DiskCache(type));
        }
        return DiskCache.disks.get(type);
    }

    private File dir;

    private DiskCache(String typeMap) {
        dir = new File(typeMap);
        dir.mkdir();
    }

    @Override
    public long size() {
        return FileUtil.dirLength(dir);
    }

    @Override
    public boolean add(String key, byte[] buf) {
        return FileUtil.copy(new ByteArrayInputStream(filterCache.doAdd(key, buf)), new File(dir, key));
    }

    @Override
    public byte[] retreive(String key) {
        try {
            return filterCache.doRetreive(key, FileUtil.readFile(new File(dir, key)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void clear() {
        FileUtil.deleteDirectory(dir);
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
