package com.misterclass.misterclassback.features.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterLoginRequestDto extends UserDto {

    private boolean exists;

}
