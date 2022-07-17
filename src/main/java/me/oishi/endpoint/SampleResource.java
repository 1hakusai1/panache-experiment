package me.oishi.endpoint;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.oishi.domain.Sample;
import me.oishi.domain.SampleRepository;

@Path("/sample")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {

    @Inject
    SampleRepository repository;

    @GET
    public List<Sample> listAll() {
        return repository.listAll();
    }

}
