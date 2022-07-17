package me.oishi.devel;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

import io.quarkus.runtime.StartupEvent;
import me.oishi.domain.Sample;
import me.oishi.domain.SampleRepository;

@ApplicationScoped
public class InitialDataRegister {

    @Inject
    SampleRepository repository;

    @Transactional
    public void initializeData(@Observes StartupEvent event) {
        for (int i = 0; i < 100; i++) {
            String message = UUID.randomUUID().toString();
            Sample sample = new Sample();
            sample.setMessage(message);
            sample.setVisitedCount(0);
            repository.persist(sample);
        }
    }

}
