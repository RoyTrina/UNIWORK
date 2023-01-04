import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestProducerConsumer {

  public static void main(String args[]) {
    test1();
  }

  public static void test1() {

    // Queue<Integer> q = new LinkedList<Integer>();
    BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(1);
    new ProducerInteger(q).start();
    new Consumer<Integer>(q).start();
  }

}
