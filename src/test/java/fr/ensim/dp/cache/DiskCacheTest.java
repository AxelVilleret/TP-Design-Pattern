package fr.ensim.dp.cache;

import org.junit.jupiter.api.Test;

import fr.ensim.dp.cache.filter.CompressFilterCache;
import fr.ensim.dp.cache.filter.CountFilterCache;
import fr.ensim.dp.cache.filter.EncryptFilterCache;
import fr.ensim.dp.cache.filter.LogFilterCache;

import static org.junit.Assert.assertArrayEquals;

public class DiskCacheTest {
    @Test
    public void testAll() {

        DiskCache.getInstance("Mapnik")
                .setFilterCache(new LogFilterCache())
                .setNext(new CountFilterCache())
                .setNext(new CompressFilterCache())
                .setNext(new EncryptFilterCache());;

        byte[] b = { 12, 2, 3 };
        DiskCache.getInstance("Mapnik").add("key1", b);
        assertArrayEquals(b, DiskCache.getInstance("Mapnik").retreive("key1"));
    }
}
