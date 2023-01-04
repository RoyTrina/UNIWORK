import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StreamsTest {

  public StreamsTest() {
  }

  @Test
  public void sumOfSquaresTest() {
    for (int n = 0; n < 10; n++) {
      assertEquals("i= " + n, ((n * (n + 1) * (2 * n + 1)) / 6),
          Streams.sumOfSquares(n));
    }
  }

}
