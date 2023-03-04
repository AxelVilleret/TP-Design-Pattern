package fr.ensim.dp.composite;

import fr.ensim.dp.cache.ICache;

public class CountSubRepo implements ICount {

    ICache cache;

    public CountSubRepo(ICache cache) {
        this.cache = cache;
    }

    @Override
    public long count() {
        return cache.size();
    }
    
}
