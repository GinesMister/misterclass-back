package com.misterclass.misterclassback.features.user.service;

import com.misterclass.misterclassback.exceptions.general.NotFoundException;
import com.misterclass.misterclassback.features.user.dto.UserDto;
import com.misterclass.misterclassback.features.user.repository.UserRepository;
import com.misterclass.misterclassback.features.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGetDataService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public UserDto getUserById(String userId) throws NotFoundException {
        var user = userRepository.findById(userId);
        if (user.isEmpty())
            throw new NotFoundException();
        return user.map(userEntity -> userMapper.entityToDto(userEntity)).orElse(null);
    }
}
