package fr.ensim.dp.composite;

import java.util.ArrayList;
import java.util.List;

public class CountRepo implements ICount {

    private List<ICount> list = new ArrayList<>();

    public void add(ICount iCount) {
        list.add(iCount);
    }

    public void remove(ICount iCount) {
        list.remove(iCount);
    }

    @Override
    public long count() {
        long sum = 0;
        for(ICount iCount : list) {
            sum += iCount.count();
        }
        return sum;
    }
    
}
