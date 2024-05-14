package concurent.Item81;

public class Message1 {
    private String message;
    private boolean empty = true;

    public synchronized String read() {
        while (empty) {
            try {
                wait(); // Chờ cho đến khi có thông điệp được gửi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true; // Đánh dấu là đối tượng Message đã rỗng
        notifyAll(); // Thông báo rằng đối tượng đã được đọc xong
        return message;
    }

    public synchronized void write(String message) {
        while (!empty) {
            try {
                wait(); // Chờ cho đến khi đối tượng Message trống
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = false; // Đánh dấu là đối tượng Message không còn rỗng
        this.message = message;
        notifyAll(); // Thông báo rằng đã gửi thông điệp thành công
    }
}

