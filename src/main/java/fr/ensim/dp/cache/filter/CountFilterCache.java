package fr.ensim.dp.cache.filter;

public class CountFilterCache implements IFilterCache {

    private int countAdd = 0;

    public int getCountAdd() {
        return countAdd;
    }

    private int countRetreive = 0;

    public int getCountRetreive() {
        return countRetreive;
    }

    private IFilterCache next = null;

    @Override
    public byte[] doAdd(String key, byte[] buf) {
        countAdd ++;
        if(next != null)
            buf = next.doAdd(key, buf);
        return buf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        if(next != null)
            buf = next.doRetreive(key, buf);
        countRetreive ++;
        return buf;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        this.next = next;
        return next;
    }
    
}
