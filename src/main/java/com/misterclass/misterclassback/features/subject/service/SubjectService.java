package com.misterclass.misterclassback.features.subject.service;

import com.misterclass.misterclassback.exceptions.general.NotFoundException;
import com.misterclass.misterclassback.features.subject.dto.subject.SimplifiedSubjectDto;
import com.misterclass.misterclassback.features.subject.dto.subject.SubjectDto;
import com.misterclass.misterclassback.features.subject.mapper.SubjectMapper;
import com.misterclass.misterclassback.features.subject.repository.SubjectRepository;
import com.misterclass.misterclassback.features.user.repository.UserRepository;
import com.misterclass.misterclassback.functions.GenerateHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

    public List<SimplifiedSubjectDto> getSubjectsByTeacherId(String teacherId) throws NotFoundException {
        var subjects = subjectMapper.entityListToSimplifiedDtoList(subjectRepository.getSubjectsByTeacherId(teacherId));
        if (subjects == null)
            throw new NotFoundException();
        return subjects;
    }

    private String createSubjectCode(SimplifiedSubjectDto newSubjectRequest) {
        // Coger todos los datos para generar un hash
        String allData = newSubjectRequest.getName()
                + newSubjectRequest.getColor()
                + newSubjectRequest.getTeacherId()
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

    public boolean updateSubject(SubjectDto subjectToUpdate, long id) {
        if (subjectToUpdate.getSubjectId() != id) return false;
        if (subjectRepository.findById(subjectToUpdate.getSubjectId()).isEmpty()) return false;
        subjectRepository.save(subjectMapper.dtoToEntity(subjectToUpdate));
        System.out.println(subjectMapper.dtoToEntity(subjectToUpdate));
        return true;
    }

    public boolean deleteSubjectById(long id) {
        var subjectToDelete = subjectRepository.findById(id);
        if (subjectToDelete.isEmpty()) return false;
        subjectRepository.delete(subjectToDelete.get());
        return true;
    }

    public SubjectDto getSubjectById(Long id) throws NotFoundException {
        var subject = subjectRepository.findById(id);
        if (subject.isEmpty()) throw new NotFoundException();
        return subjectMapper.entityToDto(subject.get());
    }

    public boolean subscribeStudentToSubject(String userId, String subjectCode) throws NotFoundException {
        var subject = subjectRepository.getSubjectByCode(subjectCode);
        if (subject == null) throw new NotFoundException();

        if (Objects.equals(subject.getTeacher().getUserId(), userId)) return false;
        subject.getStudents().add(userRepository.findById(userId).get());
        subjectRepository.save(subject);
        return true;
    }
}