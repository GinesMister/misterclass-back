package com.misterclass.misterclassback.features.subject.controller;

import com.misterclass.misterclassback.exceptions.general.NotFoundException;
import com.misterclass.misterclassback.features.subject.dto.subject.SimplifiedSubjectDto;
import com.misterclass.misterclassback.features.subject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/subject/createSubject")
    public ResponseEntity<SimplifiedSubjectDto> createSubject(@RequestBody SimplifiedSubjectDto newSubject) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.createSubject(newSubject));
    }

    @GetMapping("/subject/getSubjectsByTeacherId")
    public ResponseEntity<List<SimplifiedSubjectDto>> getSubjectsByTeacherId(@RequestParam String teacherId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(subjectService.getSubjectsByTeacherId(teacherId));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
