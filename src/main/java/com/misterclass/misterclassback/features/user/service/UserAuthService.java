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
            try {
                userRepository.save(reqUserEntity);
            } catch(Exception e) {
                return false;
            }
            return true;
        }

        // Loggear
        if (userToLog.isEmpty()) return false;
        return Objects.equals(userToLog.get().getPassword(), regLogRequest.getPassword())
                && Objects.equals(userToLog.get().getUserId(), regLogRequest.getUserId());
    }

    // TODO Lista de endpoints:
    /*
    Subscribirse mediante código
     */
}
