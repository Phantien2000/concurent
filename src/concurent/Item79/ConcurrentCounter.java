package concurent.Item79;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCounter {
    private ConcurrentHashMap<String, Integer> counts = new ConcurrentHashMap<>();

    public void increment(String key) {
        counts.compute(key, (k, v) -> (v == null) ? 1 : v + 1);
    }

    public int getCount(String key) {
        return counts.getOrDefault(key, 0);
    }
}

