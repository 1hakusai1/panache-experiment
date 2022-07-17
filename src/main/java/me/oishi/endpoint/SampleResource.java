package me.oishi.endpoint;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.RestPath;

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

    @GET
    @Path("/{id}")
    public Sample findByID(@RestPath Long id) {
        return repository.findById(id);
    }

    @POST
    @Path("/{id}")
    @Transactional
    public Sample visit(@RestPath Long id) {
        Sample sample = repository.findByIdOptional(id).orElseThrow();
        int currentCount = sample.getVisitedCount();
        sample.setVisitedCount(currentCount + 1);
        return sample;
    }

}
