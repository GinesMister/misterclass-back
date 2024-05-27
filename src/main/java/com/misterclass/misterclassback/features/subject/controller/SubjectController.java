package com.misterclass.misterclassback.features.subject.controller;

import com.misterclass.misterclassback.features.subject.dto.subject.SimplifiedSubjectDto;
import com.misterclass.misterclassback.features.subject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/subject/createSubject")
    public ResponseEntity<SimplifiedSubjectDto> createSubject(@RequestBody SimplifiedSubjectDto newSubject) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.createSubject(newSubject));
    }
}
