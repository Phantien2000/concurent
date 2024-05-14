package concurent.Item78;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter2 counter1 = new Counter2();

        // Tạo các luồng để tăng count
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter1.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter1.increment();
            }
        });

        // Khởi động các luồng
        thread1.start();
        thread2.start();

        // Đợi các luồng kết thúc
        thread1.join();
        thread2.join();

        // In ra giá trị count
        System.out.println("Count: " + counter1.getCount());
    }
}

