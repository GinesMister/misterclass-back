package com.misterclass.misterclassback.features.user.dto;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterLoginRequestDto {

    private String userId;

    private String password;

    private boolean exists;

}
