import java.util.*;

// Thread consuming some values from a queue

public class Consumer<A> extends Thread {

  private static final int maxDelay = 500;
  private static final int n = 10;
  private Queue<A> queue;

  public Consumer(Queue<A> q) {
    super("Consumer");
    this.queue = q;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < n; i++) {
        A retrieved = queue.poll();
        System.out.println(getName() + " retrieved: " + retrieved);

        // small time delay
        Thread.sleep((int) (Math.random() * maxDelay));
      }
    } catch (InterruptedException e) {
    }
  }
}
