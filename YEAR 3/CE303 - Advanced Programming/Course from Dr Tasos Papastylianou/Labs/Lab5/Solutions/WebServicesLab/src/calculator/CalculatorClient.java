package calculator;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class CalculatorClient {

	public static final String HOST = "localhost:8080/examples/rest";
	public static final String URL = "http://" + HOST + "/calculator/add";

	public WebTarget target;

	public CalculatorClient() {
		this(URL);
	}

	public CalculatorClient(String url) {
		Client client = ClientBuilder.newClient();
		target = client.target(url);
	}

	public int addWithPathParam(int x, int y) {
		return target.path("" + x).path("" + y).request().get(Integer.class);
	}

	public int addWithQueryParam(int x, int y) {
		return target.queryParam("x", x).queryParam("y", y).request().get(Integer.class);
	}

	public int addWithPOST(int... numbers) {
		return target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(numbers), Integer.class);
	}

	public static void main(String[] args) {
		CalculatorClient client = new CalculatorClient(URL);
		System.out.println("addWithPathParam(1,2)=" + client.addWithPathParam(1, 2));
		System.out.println("addWithQueryParam(1,2)=" + client.addWithQueryParam(1, 2));
		System.out.println("addWithPost([1,2,3])=" + client.addWithPOST(1, 2, 3));

	}
}
