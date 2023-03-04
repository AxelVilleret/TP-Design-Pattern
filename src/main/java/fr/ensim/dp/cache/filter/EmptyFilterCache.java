package fr.ensim.dp.cache.filter;

public class EmptyFilterCache implements IFilterCache {

    @Override
    public byte[] doAdd(String key, byte[] buf) {
        return buf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        return buf;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        return null;
    }
}
