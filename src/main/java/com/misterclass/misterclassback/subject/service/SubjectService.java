package com.misterclass.misterclassback.subject.service;

import com.misterclass.misterclassback.subject.dto.UnitDto;
import com.misterclass.misterclassback.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private UserRepository userRepository;

    public UnitDto getSubjectByUserId(String userId) {

        return null;
    }
}