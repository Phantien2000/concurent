package concurent.Item81;

public class Main {
    public static void main(String[] args) {
        Message2 message1 = new Message2();

        // Tạo và khởi chạy luồng đọc
        Thread readerThread = new Thread(() -> {
            String receivedMessage = null;
            try {
                receivedMessage = message1.read();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Received message: " + receivedMessage);
        });
        readerThread.start();

        // Tạo và khởi chạy luồng ghi
        Thread writerThread = new Thread(() -> {
            try {
                message1.write("Hello from writer!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        writerThread.start();
    }
}

