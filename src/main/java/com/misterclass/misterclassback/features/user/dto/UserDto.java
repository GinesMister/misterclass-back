package com.misterclass.misterclassback.features.user.dto;

import com.misterclass.misterclassback.features.subject.dto.SubjectDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private List<SubjectDto> subjectsSubscribed;
}
