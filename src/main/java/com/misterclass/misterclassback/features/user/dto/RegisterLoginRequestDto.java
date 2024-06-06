package com.misterclass.misterclassback.features.user.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterLoginRequestDto extends UserDto {

    private String password;

    private boolean exists;

}
