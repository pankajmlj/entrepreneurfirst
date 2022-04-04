package com.privado.entrepreneurfirst.model;

import java.util.ArrayList;
import java.util.List;

public class CandidateDataSet {
    private List<Candidate> salesCandidate;
    private List<Candidate> marketingCandidate;
    private List<Candidate> engineerCandidate;

    private List<Candidate> oldSalesCandidate;
    private List<Candidate> oldMarketingCandidate;
    private List<Candidate> oldEngineerCandidate;
    private int counterOldAgeCandidates;
    private int engineerCounter;
    private int salesCounter;
    private int marketingCounter;
    private String location;


    public CandidateDataSet() {
        salesCandidate = new ArrayList<Candidate>();
        marketingCandidate = new ArrayList<Candidate>();
        engineerCandidate = new ArrayList<Candidate>();

        oldSalesCandidate = new ArrayList<Candidate>();
        oldMarketingCandidate = new ArrayList<Candidate>();
        oldEngineerCandidate = new ArrayList<Candidate>();
        counterOldAgeCandidates = 0;
        engineerCounter = 0;
        salesCounter = 0;
        marketingCounter = 0;
    }

    public int getEngineerCounter() {
        return engineerCounter;
    }

    public int getSalesCounter() {
        return salesCounter;
    }

    public int getMarketingCounter() {
        return marketingCounter;
    }

    public void increaseEngineerCounter() {
        engineerCounter += 1;
    }

    public void increaseSalesCounter() {
        salesCounter += 1;
    }

    public void increaseMarketingCounter() {
        marketingCounter += 1;
    }

    public void decreaseEngineerCounter() {
        engineerCounter -= 1;
    }

    public void decreaseSalesCounter() {
        salesCounter -= 1;
    }

    public void decreaseMarketingCounter() {
        marketingCounter -= 1;
    }

    public List<Candidate> getSalesCandidate() {
        return salesCandidate;
    }

    public void setSalesCandidate(List<Candidate> salesCandidate) {
        this.salesCandidate = salesCandidate;
    }

    public List<Candidate> getMarketingCandidate() {
        return marketingCandidate;
    }

    public void setMarketingCandidate(List<Candidate> marketingCandidate) {
        this.marketingCandidate = marketingCandidate;
    }

    public List<Candidate> getEngineerCandidate() {
        return engineerCandidate;
    }

    public void setEngineerCandidate(List<Candidate> engineerCandidate) {
        this.engineerCandidate = engineerCandidate;
    }

    public List<Candidate> getOldSalesCandidate() {
        return oldSalesCandidate;
    }

    public void setOldSalesCandidate(List<Candidate> oldSalesCandidate) {
        this.oldSalesCandidate = oldSalesCandidate;
    }

    public List<Candidate> getOldMarketingCandidate() {
        return oldMarketingCandidate;
    }

    public void setOldMarketingCandidate(List<Candidate> oldMarketingCandidate) {
        this.oldMarketingCandidate = oldMarketingCandidate;
    }

    public List<Candidate> getOldEngineerCandidate() {
        return oldEngineerCandidate;
    }

    public void setOldEngineerCandidate(List<Candidate> oldEngineerCandidate) {
        this.oldEngineerCandidate = oldEngineerCandidate;
    }

    public int getCounterOldAgeCandidates() {
        return counterOldAgeCandidates;
    }

    public void increaseCounterOldAgeCandidates() {
        counterOldAgeCandidates += 1;
    }
    public void decreaseCounterOldAgeCandidates() {
        counterOldAgeCandidates -= 1;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
