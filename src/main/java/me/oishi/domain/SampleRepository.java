package me.oishi.domain;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class SampleRepository implements PanacheRepository<Sample> {

}
