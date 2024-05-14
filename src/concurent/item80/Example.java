package concurent.item80;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example {
    public static void main(String[] args) {
        // Tạo một ExecutorService với ThreadPool có 5 luồng
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Tạo danh sách các số nguyên từ 1 đến 100
        List<Integer> numbers = IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toList());

        // Sử dụng Executor để thực thi các nhiệm vụ in số chẵn ra màn hình
        numbers.forEach(number -> executor.submit(() -> {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        }));

        // Đóng ExecutorService sau khi thực thi xong
        executor.shutdown();
    }
}


