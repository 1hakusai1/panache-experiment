package me.oishi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sample {

    @Id
    @GeneratedValue
    private Long id;

    private String message;
    private int visitedCount;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> postedMessages = new ArrayList<>();

    public Sample() {
    }

    public Sample(String message) {
        visitedCount = 0;
        this.message = message;
    }

    public void visit() {
        visitedCount = visitedCount + 1;
        postedMessages.add("posted");
    }

    public String greet() {
        return "Hello " + message;
    }
}
