package com.misterclass.misterclassback.features.user.controller;

import com.misterclass.misterclassback.exceptions.general.NotFoundException;
import com.misterclass.misterclassback.features.user.dto.RegisterLoginRequestDto;
import com.misterclass.misterclassback.features.user.dto.UserDto;
import com.misterclass.misterclassback.features.user.service.UserAuthService;
import com.misterclass.misterclassback.features.user.service.UserGetDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserGetDataService userGetDataService;
    @Autowired
    private UserAuthService userAuthService;

    @GetMapping("user/getById")
    public ResponseEntity<UserDto> getUserById(@RequestParam String userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userGetDataService.getUserById(userId));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("user/registerLogin")
    public ResponseEntity<Boolean> registerLogin(@RequestBody RegisterLoginRequestDto regLogRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(userAuthService.registerLogin(regLogRequest));
    }
}
