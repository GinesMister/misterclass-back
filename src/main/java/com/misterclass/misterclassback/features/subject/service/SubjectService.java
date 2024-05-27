package com.misterclass.misterclassback.features.subject.service;

import com.misterclass.misterclassback.features.subject.dto.subject.SimplifiedSubjectDto;
import com.misterclass.misterclassback.features.subject.mapper.SubjectMapper;
import com.misterclass.misterclassback.features.subject.repository.SubjectRepository;
import com.misterclass.misterclassback.features.user.repository.UserRepository;
import com.misterclass.misterclassback.functions.GenerateHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SubjectService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectMapper subjectMapper;

    public SimplifiedSubjectDto createSubject(SimplifiedSubjectDto newSubjectRequest) {
        newSubjectRequest.setAccessCode(createSubjectCode(newSubjectRequest));
        var subjectToInsert = subjectMapper.simplifiedDtoToEntity(newSubjectRequest);

        // Insertar en BD
        subjectRepository.save(subjectToInsert);
        return newSubjectRequest;
    }

    private String createSubjectCode(SimplifiedSubjectDto newSubjectRequest) {
        // Coger todos los datos para generar un hash
        String allData = newSubjectRequest.getName()
                + newSubjectRequest.getColor()
                + newSubjectRequest.getTeacher()
                + LocalDateTime.now();

        // Coger 6 dígitos del hash
        var hash = GenerateHash.generateSHA256Hash(allData);
        var code = hash.toUpperCase().substring(0, 6);

        // Repetir hasta que no haya un código igual
        for (int i = 1; subjectRepository.existSubjectByCode(code); i++) {
            code = hash.substring(i, 6 + i);
        }
        return code;
    }
}