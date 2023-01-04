import java.util.*;

// Thread "producing" some random integers and inserting them in a queue
public class ProducerInteger extends Thread {

  private Queue<Integer> queue;
  private static final int maxDelay = 500;
  private static final int n = 10;

  public ProducerInteger(Queue<Integer> q) {
    super("Producer");
    queue = q;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < n; i++) {
        int val = (int) (Math.random() * n);
        queue.offer(val);
        System.out.println(getName() + " produced " + val);
        // small delay
        Thread.sleep((int) (Math.random() * maxDelay));
      }
    } catch (InterruptedException e) {
    }

  }
}
