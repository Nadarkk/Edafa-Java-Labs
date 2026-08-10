import java.util.*;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue){
        this.queue=queue;
    }

    public BlockingQueue<Integer> getQueue() {
        return queue;
    }

    @Override
    public void run(){
        while(true){
            try {
                System.out.println("Took: " + queue.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer thread interrupted");
            }
        }
    }
}
