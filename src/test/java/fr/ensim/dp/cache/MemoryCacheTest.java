package fr.ensim.dp.cache;


import org.junit.jupiter.api.Test;

import fr.ensim.dp.cache.filter.CompressFilterCache;
import fr.ensim.dp.cache.filter.CountFilterCache;
import fr.ensim.dp.cache.filter.EncryptFilterCache;
import fr.ensim.dp.cache.filter.LogFilterCache;

import static org.junit.Assert.assertArrayEquals;

public class MemoryCacheTest {

	@Test
	public void testAll() {
		MemoryCache.getInstance()
		.setFilterCache(new LogFilterCache())
		.setNext(new CountFilterCache())
		.setNext(new EncryptFilterCache())
		.setNext(new CompressFilterCache());

		byte [] b = {12, 2 ,3};
		MemoryCache.getInstance().add("key1", b);
		assertArrayEquals(b, MemoryCache.getInstance().retreive("key1"));
	}
}
