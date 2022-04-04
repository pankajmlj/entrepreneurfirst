package com.privado.entrepreneurfirst.service;

import com.privado.entrepreneurfirst.model.Candidate;
import com.privado.entrepreneurfirst.model.ResultGroups;

import java.util.List;

public interface Groupping {
    public ResultGroups createAndSave(List<Candidate> candidates);
}
