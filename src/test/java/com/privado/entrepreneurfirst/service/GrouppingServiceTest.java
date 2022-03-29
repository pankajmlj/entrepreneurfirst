package com.privado.entrepreneurfirst.service;

import com.privado.entrepreneurfirst.model.ResultGroups;
import com.privado.entrepreneurfirst.repository.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GrouppingServiceTest {
    GroupRepository mockGroupRepo;
    @BeforeEach
    void setUp() {
        mockGroupRepo = Mockito.mock(GroupRepository.class);
    }

    @Test
    void createAndSave() {
        GrouppingService svc = new GrouppingService(mockGroupRepo);
        ResultGroups rg = new ResultGroups();
        when(mockGroupRepo.save(Mockito.any())).thenReturn(rg);
        ResultGroups rg2  = svc.createAndSave(Collections.emptyList());
        assertEquals(rg, rg2);
//        Candidate yourclass = new Gson().fromJson(File(""), Candidate.class)
    }
}