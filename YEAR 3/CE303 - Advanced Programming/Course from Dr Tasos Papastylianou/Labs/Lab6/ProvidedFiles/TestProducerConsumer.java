package labs.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class TestProducerConsumer {

  public static void main(String args[]) {
    test1();
  }

  public static void test1() {

    Queue<Integer> q = new LinkedList<Integer>();
    new ProducerInteger(q).start();
    new Consumer<Integer>(q).start();
  }

}
