package com.misterclass.misterclassback.features.user.dto;

import com.misterclass.misterclassback.features.subject.dto.subject.SimplifiedSubjectDto;
import com.misterclass.misterclassback.features.subject.dto.subject.SubjectDto;
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

    private List<SimplifiedSubjectDto> subjectsSubscribed;

    // TODO Lista para las asignaturas creadas. Cuando se crea aquí, hay un bucle.
}
