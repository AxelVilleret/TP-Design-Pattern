package fr.ensim.dp.cache;

public class FactoryImpl implements IFactory {

    private static FactoryImpl singleton = new FactoryImpl();

    private FactoryImpl(){}

    public static IFactory getInstance() {
        return singleton;
    }

    @Override
    public ICache createDiskCache(String typeMap) {
        return DiskCache.getInstance(typeMap);
    }

    @Override
    public ICache createMemoryCache() {
        return MemoryCache.getInstance();
    }  
}
