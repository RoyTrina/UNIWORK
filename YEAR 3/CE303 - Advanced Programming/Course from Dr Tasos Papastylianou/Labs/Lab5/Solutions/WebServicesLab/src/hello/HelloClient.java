package hello;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

import webserver.TomcatServer;

public class HelloClient {

	public WebTarget webTarget;

	public HelloClient() {
		webTarget = ClientBuilder.newClient().target(TomcatServer.HELLO_URL);
	}

	public String helloPathParam(String name) {
		return webTarget.path(name).request().get(String.class);
	}

	public String helloQueryParam(String name) {
		return webTarget.queryParam("name", name).request().get(String.class);
	}

	public String helloPost(String name) {
		return webTarget.request().post(Entity.json(name), String.class);
	}

	public String helloForm(String name) {
		Form form = new Form();
		form.param("name", name);
		return webTarget.path("form").request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED))
				.readEntity(String.class);
	}

	public static void main(String[] args) {
		HelloClient client = new HelloClient();
		System.out.println("helloPathParam: " + client.helloPathParam("Alice")); 
		System.out.println("helloQueryParam: " + client.helloQueryParam("Bob")); 
		System.out.println("helloPost:" + client.helloPost("Charlie"));
		System.out.println("helloForm:" + client.helloForm("Dorothy"));
	}
}
