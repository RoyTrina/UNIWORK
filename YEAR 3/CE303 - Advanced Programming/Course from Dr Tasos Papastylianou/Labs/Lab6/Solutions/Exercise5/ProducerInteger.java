import java.util.concurrent.BlockingQueue;

// Thread "producing" some random integers and inserting them in a ArrayBlockingQueue
public class ProducerInteger extends Thread {

  private BlockingQueue<Integer> queue;
  private static final int maxDelay = 500;
  private static final int n = 10;

  public ProducerInteger(BlockingQueue<Integer> q) {
    super("Producer");
    queue = q;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < n; i++) {
        int val = (int) (Math.random() * n);
        queue.put(val);
        System.out.println(getName() + " produced " + val);
        // small delay
        Thread.sleep((int) (Math.random() * maxDelay));
      }
    } catch (InterruptedException e) {
    }

  }
}
