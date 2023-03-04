package fr.ensim.dp.cache.filter;

import java.io.IOException;

import fr.ensim.dp.util.GzipUtil;

public class CompressFilterCache implements IFilterCache {

    private IFilterCache next = null;

    @Override
    public byte[] doAdd(String key, byte[] buf) {
        try {
            buf = GzipUtil.compress(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(next != null)
            buf = next.doAdd(key, buf);
        return buf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        if(next != null)
            buf = next.doRetreive(key, buf);
        try {
            buf = GzipUtil.uncompress(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        this.next = next;
        return next;
    }
    
}
