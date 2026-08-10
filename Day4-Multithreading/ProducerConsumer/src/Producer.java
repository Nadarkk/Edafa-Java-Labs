import java.util.*;
import java.util.concurrent.BlockingQueue;


public class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue){
        this.queue=queue;
    }

    public BlockingQueue<Integer> getQueue() {
        return queue;
    }

    @Override
    public void run(){
        for(int i=1; i<=10; i++){
            try {
                queue.put(i);
                System.out.println("Produced: " + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer thread interrupted");
            }
        }
    }
}
