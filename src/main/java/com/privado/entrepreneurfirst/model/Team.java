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
	private int isAnyCandidateGraterThan35;
	private String location;

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

	public int getIsAnyCandidateGraterThan35() {
		return isAnyCandidateGraterThan35;
	}

	public void setIsAnyCandidateGraterThan35(int isAnyCandidateGraterThan35) {
		this.isAnyCandidateGraterThan35 = isAnyCandidateGraterThan35;
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