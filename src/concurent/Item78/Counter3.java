package concurent.Item78;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter3 {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet(); // Tăng giá trị atomic một cách an toàn
    }

    public int getCount() {
        return count.get(); // Lấy giá trị atomic một cách an toàn
    }
}
