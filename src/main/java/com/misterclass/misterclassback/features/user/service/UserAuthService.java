package com.misterclass.misterclassback.features.user.service;

import com.misterclass.misterclassback.features.user.dto.RegisterLoginRequestDto;
import com.misterclass.misterclassback.features.user.mapper.UserMapper;
import com.misterclass.misterclassback.features.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserAuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public boolean registerLogin(RegisterLoginRequestDto regLogRequest) {
        var reqUserEntity = userMapper.regLogReqDtoToEntity(regLogRequest);
        var userToLog = userRepository.findById(regLogRequest.getUserId());

        System.out.println(regLogRequest);
        // Registrar
        if (!regLogRequest.isExists()) {
            if (userToLog.isPresent()) return false;
            userRepository.save(reqUserEntity);
            return true;
        }

        // Loggear
        if (userToLog.isEmpty()) return false;
        return Objects.equals(userToLog.get().getPassword(), regLogRequest.getPassword())
                && Objects.equals(userToLog.get().getUserId(), regLogRequest.getUserId());
    }

    // TODO Lista de endpoints:
    /*
    - Create de Units, TheoryElement y task.

    - Update SIMPLE para TheoryElement y Task, Unit y Subjects.
    - Delete SIMPLE para TheoryElement, Task, Unit y Subjects.

    ANOTACIÓN: solo con el crear y update subject, ya lo puedo crear y actualizar TODO

    (Una vez creado todo, ya se puede hacer una aplicación en front-end
    funcional, en caso de que haya algo complicado, se puede crear un endpoint en el
    back-end para simplificar la tarea en el front-end).
     */
}
