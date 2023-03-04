package fr.ensim.dp.cache.filter;

import fr.ensim.dp.util.AES;

public class EncryptFilterCache implements IFilterCache {

    private IFilterCache next = null;

    @Override
    public byte[] doAdd(String key, byte[] buf) {
        buf = AES.encryptAES(buf, AES.KEY);
        if(next != null)
            buf = next.doAdd(key, buf);
        return buf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        if(next != null)
            buf = next.doRetreive(key, buf);
        buf = AES.decryptAES(buf, AES.KEY);
        return buf;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        this.next = next;
        return next;
    }
    
}
