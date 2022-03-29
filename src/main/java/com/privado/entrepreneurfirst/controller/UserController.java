package com.privado.entrepreneurfirst.controller;

import java.util.*;

import com.privado.entrepreneurfirst.dal.CandidateDAL;
import com.privado.entrepreneurfirst.repository.CandidateRepository;

import com.privado.entrepreneurfirst.model.Candidate;
import com.privado.entrepreneurfirst.model.ResultGroups;
import com.privado.entrepreneurfirst.service.GrouppingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/")
@Validated
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final CandidateRepository candidateRepository;
	private final CandidateDAL candidateDAL;

	private final GrouppingService grouppingService;


	public UserController(CandidateRepository candidateRepository, CandidateDAL candidateDAL, GrouppingService grouppingService) {
		this.candidateRepository = candidateRepository;
		this.candidateDAL = candidateDAL;
		this.grouppingService = grouppingService;
	}

	@RequestMapping(value = "/groups", method = RequestMethod.POST)
	public ResultGroups groups(@Valid @RequestBody List<Candidate> candidates) {
		LOG.info("Creating groups Candidate.");
		return grouppingService.createAndSave(candidates);
}
}