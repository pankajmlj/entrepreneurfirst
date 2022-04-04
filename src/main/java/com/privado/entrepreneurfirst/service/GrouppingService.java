package com.privado.entrepreneurfirst.service;

import com.privado.entrepreneurfirst.model.Candidate;
import com.privado.entrepreneurfirst.model.CandidateDataSet;
import com.privado.entrepreneurfirst.model.ResultGroups;
import com.privado.entrepreneurfirst.model.Team;
import org.springframework.stereotype.Component;

import com.privado.entrepreneurfirst.repository.GroupRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GrouppingService implements Groupping {
    private final GroupRepository groupRepository;

    public GrouppingService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Map<String, CandidateDataSet> buildCandidateDataSet(List<Candidate> candidates) {
        Map<String, CandidateDataSet> candidateDataSetMap = new HashMap<String, CandidateDataSet>();
        //Processs candidates
        for (Candidate candidate : candidates) {
            CandidateDataSet candidateDataSet = candidateDataSetMap.get(candidate.getLocation());
            if (candidateDataSet == null) {
                candidateDataSet = new CandidateDataSet();
                candidateDataSetMap.put(candidate.getLocation(), candidateDataSet);
            }
            switch (candidate.getRole()) {
                case "Engineer":
                    if (candidate.getAge() >= 35) {
                        candidateDataSet.getOldEngineerCandidate().add(candidate);
                        candidateDataSet.increaseCounterOldAgeCandidates();
                    } else
                        candidateDataSet.getEngineerCandidate().add(candidate);
                    candidateDataSet.increaseEngineerCounter();
                    break;
                case "Sales":
                    if (candidate.getAge() >= 35) {
                        candidateDataSet.getOldSalesCandidate().add(candidate);
                        candidateDataSet.increaseCounterOldAgeCandidates();
                    } else
                        candidateDataSet.getSalesCandidate().add(candidate);
                    candidateDataSet.increaseSalesCounter();
                    break;
                case "Marketing":
                    if (candidate.getAge() >= 35) {
                        candidateDataSet.getOldMarketingCandidate().add(candidate);
                        candidateDataSet.increaseCounterOldAgeCandidates();
                    } else
                        candidateDataSet.getMarketingCandidate().add(candidate);
                    candidateDataSet.increaseMarketingCounter();
                    break;
            }
        }
        return candidateDataSetMap;
    }

    public ResultGroups createGroups(Map<String, CandidateDataSet> candidateDataSetMap) {
        ResultGroups resultGroups = new ResultGroups();
        for (String location : candidateDataSetMap.keySet()) {
            CandidateDataSet candidateDataSet = candidateDataSetMap.get(location);
            List<Team> teams = buildTeamsForCandidatesForLocation(candidateDataSet);
            List<Candidate> nonGroup = buildNonGroupCandidates(candidateDataSet);

            for (Team team : teams) {
                ArrayList<Candidate> group = new ArrayList<Candidate>();
                group.add(team.getMarketingCandidate());
                group.add(team.getSalesCandidate());
                group.addAll(team.getEngineerCandidate());
                resultGroups.getGroups().add(group);
            }
            resultGroups.setNongroups(nonGroup);

        }
        return resultGroups;
    }


    private List<Team> buildTeamsForCandidatesForLocation(CandidateDataSet candidateDataSet) {
        List<Team> teams = new ArrayList<Team>();

        while (candidateDataSet.getCounterOldAgeCandidates() > 0 && candidateDataSet.getEngineerCounter() > 0 &&
                candidateDataSet.getSalesCounter() > 0 && candidateDataSet.getMarketingCounter() > 0) {
            Team team = new Team();
            //Fill Old Candidate
            candidateDataSet.decreaseCounterOldAgeCandidates();
            if (candidateDataSet.getOldEngineerCandidate().size() > 0) {
                team.getEngineerCandidate().add(candidateDataSet.getOldEngineerCandidate().remove(0));
                candidateDataSet.decreaseEngineerCounter();
            } else if (candidateDataSet.getOldMarketingCandidate().size() > 0) {
                team.setMarketingCandidate(candidateDataSet.getOldMarketingCandidate().remove(0));
                candidateDataSet.decreaseMarketingCounter();
            } else if (candidateDataSet.getOldSalesCandidate().size() > 0) {
                team.setSalesCandidate(candidateDataSet.getOldSalesCandidate().remove(0));
                candidateDataSet.decreaseSalesCounter();
            }

            //fill engineer if null
            if (team.getEngineerCandidate().size() <= 0) {
                candidateDataSet.decreaseEngineerCounter();
                if (candidateDataSet.getEngineerCandidate().size() > 0) {
                    team.getEngineerCandidate().add(candidateDataSet.getEngineerCandidate().remove(0));
                } else {
                    team.getEngineerCandidate().add(candidateDataSet.getOldEngineerCandidate().remove(0));
                    candidateDataSet.decreaseCounterOldAgeCandidates();
                }
            }
            //fill Marketing if null
            if (team.getMarketingCandidate() == null) {
                candidateDataSet.decreaseMarketingCounter();
                if (candidateDataSet.getMarketingCandidate().size() > 0) {
                    team.setMarketingCandidate(candidateDataSet.getMarketingCandidate().remove(0));
                } else {
                    team.setMarketingCandidate(candidateDataSet.getOldMarketingCandidate().remove(0));
                    candidateDataSet.decreaseCounterOldAgeCandidates();
                }
            }
            //Add Sales if null
            if (team.getSalesCandidate() == null) {
                candidateDataSet.decreaseSalesCounter();
                if (candidateDataSet.getSalesCandidate().size() > 0) {
                    team.setSalesCandidate(candidateDataSet.getSalesCandidate().remove(0));

                } else {
                    team.setSalesCandidate(candidateDataSet.getOldSalesCandidate().remove(0));
                    candidateDataSet.decreaseCounterOldAgeCandidates();
                }
            }
            teams.add(team);
        }
        //Add all remaining engineers to the team
        if (candidateDataSet.getEngineerCandidate().size() > 0) {
            if (teams.size() > 0) {
                teams.get(0).getEngineerCandidate().addAll(candidateDataSet.getEngineerCandidate());
                teams.get(0).getEngineerCandidate().addAll(candidateDataSet.getOldEngineerCandidate());
                candidateDataSet.setEngineerCandidate(new ArrayList<Candidate>());
                candidateDataSet.setOldEngineerCandidate(new ArrayList<Candidate>());
            }
        }
        return teams;
    }

    private List<Candidate> buildNonGroupCandidates(CandidateDataSet candidateDataSet) {
        List<Candidate> nonGroup = candidateDataSet.getEngineerCandidate();
        nonGroup.addAll(candidateDataSet.getSalesCandidate());
        nonGroup.addAll(candidateDataSet.getMarketingCandidate());
        nonGroup.addAll(candidateDataSet.getOldEngineerCandidate());
        nonGroup.addAll(candidateDataSet.getOldMarketingCandidate());
        nonGroup.addAll(candidateDataSet.getOldSalesCandidate());
        return nonGroup;
    }

    public ResultGroups createAndSave(List<Candidate> candidates) {
        return groupRepository.save(createGroups(buildCandidateDataSet(candidates)));
    }
}
