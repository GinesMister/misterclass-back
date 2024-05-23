package com.misterclass.misterclassback.features.user.controller;

import com.misterclass.misterclassback.exceptions.general.NotFoundException;
import com.misterclass.misterclassback.features.user.dto.UserDto;
import com.misterclass.misterclassback.features.user.service.UserGetDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserGetDataController {

    @Autowired
    private UserGetDataService userGetDataService;

    /* TODO Crear ResponseUserDto, para que esta función que se ejecutará al iniciar,
        no devuelve información excesiva. Gracias.
     */
    @GetMapping("user/getById")
    public ResponseEntity<UserDto> getUserById(@RequestParam String userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userGetDataService.getUserById(userId));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
