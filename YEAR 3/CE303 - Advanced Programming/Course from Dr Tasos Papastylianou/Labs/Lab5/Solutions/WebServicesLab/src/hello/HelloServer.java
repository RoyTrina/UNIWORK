package hello;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloServer {

	@GET
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloPlain(@PathParam("name") String name) {
		return "Hello, " + name + "!";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String helloJson(@QueryParam("name") String name) {
		return "{\"hello\":\"" + name + "\"}";
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String helloPost(String name) {
		return "{\"hello\":\"" + name +"\"}"; 
	}
	
	@POST
	@Path("/form")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String helloForm(@FormParam ("name") String name) {
		return "{\"hello\":\"" + name +"\"}"; 
	}
}