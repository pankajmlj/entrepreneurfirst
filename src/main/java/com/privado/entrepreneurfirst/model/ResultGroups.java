package com.privado.entrepreneurfirst.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document
public class ResultGroups {

    @Id
    private String groupId;

	private List<List<Candidate>> groups = new ArrayList<List<Candidate>>();
	private List<Candidate> nongroups = new ArrayList<Candidate>();

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public List<List<Candidate>> getGroups() {
		return groups;
	}

	public void setGroups(List<List<Candidate>> groups) {
		this.groups = groups;
	}

	public List<Candidate> getNongroups() {
		return nongroups;
	}

	public void setNongroups(List<Candidate> nongroups) {
		this.nongroups = nongroups;
	}
}