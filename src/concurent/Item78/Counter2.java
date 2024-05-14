package concurent.Item78;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter2 {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // Lock được sử dụng để bắt đầu một vùng đồng bộ hóa
        try {
            count++;
        } finally {
            lock.unlock(); // Mở khóa để cho các luồng khác có thể truy cập vào vùng đồng bộ hóa
        }
    }

    public int getCount() {
        lock.lock(); // Lock được sử dụng để bắt đầu một vùng đồng bộ hóa
        try {
            return count;
        } finally {
            lock.unlock(); // Mở khóa để cho các luồng khác có thể truy cập vào vùng đồng bộ hóa
        }
    }
}

