package me.oishi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sample {

    @Id
    @GeneratedValue
    private Long id;

    private String message;
    private int visitedCount;

    public Sample() {
    }

    public Sample(String message) {
        visitedCount = 0;
        this.message = message;
    }

    public void increment() {
        visitedCount = visitedCount + 1;
    }

    public String greet() {
        return "Hello " + message;
    }

}
