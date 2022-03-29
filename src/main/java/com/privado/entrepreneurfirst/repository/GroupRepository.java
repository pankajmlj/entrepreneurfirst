package com.privado.entrepreneurfirst.repository;

import com.privado.entrepreneurfirst.model.Candidate;
import com.privado.entrepreneurfirst.model.ResultGroups;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GroupRepository extends MongoRepository<ResultGroups, String> {
}