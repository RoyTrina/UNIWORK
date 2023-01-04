import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

  public static void main(String[] args) {
    List<Integer> primes = primes(1000);
    System.out.println("First 15 primes are: " + primes.subList(0, 15));
    System.out.println("The 1000th prime is: " + primes(1000).get(999));
    testComputeNPPs();
  }

  public static int sumOfSquares(int n) {
    return IntStream.rangeClosed(1, n).map(m -> m * m).sum();
  }

  public static boolean isPrime(int n) {
    IntStream divisors = IntStream.rangeClosed(2, (int) Math.sqrt(n));
    return divisors.noneMatch((m) -> n % m == 0);
  }

  public static List<Integer> primes(int n) {
    Stream<Integer> oddPrimes = Stream.iterate(3, i -> i + 2).filter(Streams::isPrime);
    Stream<Integer> allPrimes = Stream.concat(Stream.of(2), oddPrimes).limit(n);
    return allPrimes.collect(Collectors.toList());
  }

  public static Stream<BigInteger> randomBigInts(int bitLength, int numberOfElems) {
    Random random = new Random();
    return IntStream.range(0, numberOfElems).mapToObj(n -> new BigInteger(bitLength, random));
  }

  public static void computeNPPs(Stream<BigInteger> arguments, boolean parallel) {
    long time0 = System.currentTimeMillis();
    if (parallel)
      arguments.parallel();
    arguments.map(BigInteger::nextProbablePrime).forEach(System.out::println);
    long timeTaken = System.currentTimeMillis() - time0;
    String modeString = parallel ? "parallel" : "sequential";
    System.out.printf("Time (%s) %d%n", modeString, timeTaken);
  }

  public static void testComputeNPPs() {
    int bitLength = 2000;
    int numberOfElems = 10;
    for (int i = 0; i < 2; i++) {
      computeNPPs(randomBigInts(bitLength, numberOfElems), false);
      computeNPPs(randomBigInts(bitLength, numberOfElems), true);
    }
  }

}
