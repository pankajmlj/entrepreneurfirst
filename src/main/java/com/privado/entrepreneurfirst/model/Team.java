package com.privado.entrepreneurfirst.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Team {

    private Candidate salesCandidate;
    private Candidate marketingCandidate;
    private List<Candidate> engineerCandidate;
    private int counterAgeGraterThan35;
    private String location;

    public Team() {
        engineerCandidate = new ArrayList<Candidate>();
    }

    public int getCounterAgeGraterThan35() {
        return counterAgeGraterThan35;
    }

    public void setCounterAgeGraterThan35(int counterAgeGraterThan35) {
        this.counterAgeGraterThan35 = counterAgeGraterThan35;
    }

    public void increaseCounterAgeGraterThan35() {
        this.counterAgeGraterThan35 += 1;
    }

    public void decreaseCounterAgeGraterThan35() {
        this.counterAgeGraterThan35 -= 1;
    }

    public Candidate getSalesCandidate() {
        return salesCandidate;
    }

    public void setSalesCandidate(Candidate salesCandidate) {
        this.salesCandidate = salesCandidate;
    }

    public Candidate getMarketingCandidate() {
        return marketingCandidate;
    }

    public void setMarketingCandidate(Candidate marketingCandidate) {
        this.marketingCandidate = marketingCandidate;
    }

    public List<Candidate> getEngineerCandidate() {
        return engineerCandidate;
    }

    public void setEngineerCandidate(List<Candidate> engineerCandidate) {
        this.engineerCandidate = engineerCandidate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Team{" +
                "salesCandidate=" + salesCandidate +
                ", marketingCandidate=" + marketingCandidate +
                ", engineerCandidate=" + engineerCandidate +
                '}';
    }
}