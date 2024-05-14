package concurent.Item81;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Message2 {
    private String message;
    private boolean empty = true;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public String read() throws InterruptedException {
        lock.lock();
        try {
            while (empty) {
                condition.await(); // Chờ cho đến khi có thông điệp được gửi
            }
            empty = true; // Đánh dấu là đối tượng Message đã rỗng
            condition.signalAll(); // Thông báo rằng đối tượng đã được đọc xong
            return message;
        } finally {
            lock.unlock();
        }
    }

    public void write(String message) throws InterruptedException {
        lock.lock();
        try {
            while (!empty) {
                condition.await(); // Chờ cho đến khi đối tượng Message trống
            }
            empty = false; // Đánh dấu là đối tượng Message không còn rỗng
            this.message = message;
            condition.signalAll(); // Thông báo rằng đã gửi thông điệp thành công
        } finally {
            lock.unlock();
        }
    }
}
