package com.misterclass.misterclassback.features.subject.dto.subject;

import com.misterclass.misterclassback.features.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimplifiedSubjectDto {

    private long subjectId;

    private String accessCode;

    private String name;

    private String color;

    private String teacherId;

}
