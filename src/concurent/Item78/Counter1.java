package concurent.Item78;

public class Counter1 {
    private int count = 0;

    // Phương thức này không đồng bộ hóa
    public void increment() {
        count++;
    }

    // Phương thức này sử dụng synchronized để đảm bảo an toàn khi truy cập dữ liệu count
    public synchronized void synchronizedIncrement() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
