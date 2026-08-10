import java.util.concurrent.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(producer);
        executor.execute(consumer);
        executor.shutdown();
    }
}

