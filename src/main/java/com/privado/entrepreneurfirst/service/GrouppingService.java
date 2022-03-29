package com.privado.entrepreneurfirst.service;

import com.privado.entrepreneurfirst.model.Candidate;
import com.privado.entrepreneurfirst.model.ResultGroups;
import com.privado.entrepreneurfirst.model.Team;
import org.springframework.stereotype.Component;

import com.privado.entrepreneurfirst.repository.GroupRepository;
import java.util.ArrayList;
import java.util.List;

@Component
public class GrouppingService implements Groupping{

    private final GroupRepository groupRepository;

    public GrouppingService(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    public ResultGroups createGroups(List<Candidate> candidates) {
        List<Team>  teams = new ArrayList<Team>();
        //Processs candidates
        for(Candidate candidate : candidates) {
            boolean isCandidateInsert = false;
            switch (candidate.getRole()) {
                case "Engineer":
                    isCandidateInsert = false;
                    for (Team team : teams) {
                        if (team.getLocation().equalsIgnoreCase(candidate.getLocation()) && team.getEngineerCandidate() == null) {
                            ArrayList<Candidate> listOfCandidate = new ArrayList<Candidate>();
                            listOfCandidate.add(candidate);
                            team.setEngineerCandidate(listOfCandidate);
                            isCandidateInsert = true;
                            break;
                        }
                    }
                    if(isCandidateInsert == false) {
                        Team newTeam = new Team();
                        ArrayList<Candidate> listOfCandidate = new ArrayList<Candidate>();
                        listOfCandidate.add(candidate);
                        newTeam.setEngineerCandidate(listOfCandidate);
                        newTeam.setLocation(candidate.getLocation());
                        teams.add(newTeam);
                    }
                    break;
                case "Sales":
                    isCandidateInsert = false;
                    for (Team team : teams) {
                        if (team.getLocation().equalsIgnoreCase(candidate.getLocation()) && team.getSalesCandidate() == null) {
                            team.setSalesCandidate(candidate);
                            isCandidateInsert = true;
                            break;
                        }
                    }
                    if(isCandidateInsert == false) {
                        Team newTeam1 = new Team();
                        newTeam1.setSalesCandidate(candidate);
                        newTeam1.setLocation(candidate.getLocation());
                        teams.add(newTeam1);
                    }
                    break;
                case "Marketing":
                    isCandidateInsert = false;
                    for (Team team : teams) {
                        if (team.getLocation().equalsIgnoreCase(candidate.getLocation()) && team.getMarketingCandidate() == null) {
                            team.setMarketingCandidate(candidate);
                            isCandidateInsert = true;
                            break;
                        }
                    }
                    if(isCandidateInsert == false) {
                        Team newTeam2 = new Team();
                        newTeam2.setMarketingCandidate(candidate);
                        newTeam2.setLocation(candidate.getLocation());
                        teams.add(newTeam2);
                    }
                    break;
            }
        }
        //identify groups
        ResultGroups resultGroups = new ResultGroups();
        for(Team team : teams){
            if(team.getEngineerCandidate() != null && team.getSalesCandidate() != null && team.getMarketingCandidate() != null){
                ArrayList<Candidate> group = new ArrayList<Candidate>();
                group.add(team.getMarketingCandidate());
                group.add(team.getSalesCandidate());
                group.addAll(team.getEngineerCandidate());

                resultGroups.getGroups().add(group);
            }
            else {
                if(team.getEngineerCandidate() != null){
                    resultGroups.getNongroups().addAll(team.getEngineerCandidate());
                }
                if(team.getSalesCandidate() != null){
                    resultGroups.getNongroups().add(team.getSalesCandidate());
                }
                if(team.getMarketingCandidate() != null){
                    resultGroups.getNongroups().add(team.getMarketingCandidate());
                }
            }

        }

    return resultGroups;
    }

    public ResultGroups createAndSave(List<Candidate> candidates) {
        return groupRepository.save(createGroups(candidates));
    }
}
