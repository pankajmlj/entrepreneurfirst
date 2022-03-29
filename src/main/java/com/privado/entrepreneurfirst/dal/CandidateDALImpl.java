package com.privado.entrepreneurfirst.dal;

import com.privado.entrepreneurfirst.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CandidateDALImpl implements CandidateDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Candidate> getAllCandidates() {
		return mongoTemplate.findAll(Candidate.class);
	}

}
