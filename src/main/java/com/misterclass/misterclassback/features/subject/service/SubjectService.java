package com.misterclass.misterclassback.features.subject.service;

import com.misterclass.misterclassback.features.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private UserRepository userRepository;

    // TODO función de crear asignatura
    /*
    TODO crear una asignatura para testear lo que devuelve el teacher del subject
    al hacer getUser
     */
}