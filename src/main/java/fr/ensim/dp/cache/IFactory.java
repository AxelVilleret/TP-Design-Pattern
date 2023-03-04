package fr.ensim.dp.cache;

public interface IFactory {
    ICache createDiskCache(String typeMap);

    ICache createMemoryCache();
}
