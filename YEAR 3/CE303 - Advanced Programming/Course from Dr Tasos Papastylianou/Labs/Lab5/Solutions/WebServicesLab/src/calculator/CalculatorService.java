package calculator;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

// Calculator JAX-RS service 

@Path("/calculator")
@Produces(MediaType.APPLICATION_JSON)
public class CalculatorService  {
	
	@GET
	@Path("/add/{x}/{y}")
	public int addPath(@PathParam("x") int x, @PathParam("y") int y) {
		System.out.println("Calculator.addPathParams"); 
		return (x + y);
	}

	@GET
	@Path("/add")
	public int addQuery(@QueryParam("x") int x, @QueryParam("y") int y) {
		System.out.println("Calculator.addQueryParams");
		return (x + y);
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public int addBody(List<Integer> numbers) {
		System.out.println("Calculator.add(" + numbers + ")");
		int result = 0;
		for (Integer x : numbers) result+= x;
		return result; 
	}
	
}