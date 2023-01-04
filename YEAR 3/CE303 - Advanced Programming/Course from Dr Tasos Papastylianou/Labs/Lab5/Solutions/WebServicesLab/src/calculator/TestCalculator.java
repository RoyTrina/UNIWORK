package calculator;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class TestCalculator {

	private Random random = new Random();
	private int x = random.nextInt(100); 
	private int y = random.nextInt(100);
	private CalculatorClient client = new CalculatorClient(); 

	public TestCalculator() {
	};

	@Test
	public void testAddPathParam() {
		int result = client.addWithPathParam(x, y);
		assertEquals(result,x+y); 
	}

	@Test
	public void testAddQueryParam() {
		int result = client.addWithQueryParam(x, y);
		assertEquals(result,x+y); 
	}

	@Test
	public void testAddPost() {
		int result = client.addWithPOST(x,y); 
		assertEquals(result,x+y); 
	}
	
}
