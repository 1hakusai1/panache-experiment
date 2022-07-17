package me.oishi.endpoint;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.RestPath;

@Path("/greet")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @GET
    public Map<String, String> greet() {
        return Map.of("message", "hello world");
    }

    @GET
    @Path("/{name}")
    public Map<String, String> greetWithName(@RestPath String name) {
        String message = "hello " + name;
        return Map.of("message", message);
    }

}
