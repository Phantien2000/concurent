package concurent.Item79;

public class Counter {
    private int count;

    public void increment() {
        synchronized (this) { // chỉ đồng bộ hóa phần tăng giá trị của count
            count++;
        }
    }

    public int getCount() {
        return count; // không đồng bộ hóa phần đọc giá trị của count
    }
}
