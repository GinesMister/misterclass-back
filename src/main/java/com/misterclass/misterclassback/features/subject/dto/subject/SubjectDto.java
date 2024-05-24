package com.misterclass.misterclassback.features.subject.dto.subject;

import com.misterclass.misterclassback.features.subject.dto.UnitDto;
import com.misterclass.misterclassback.features.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectDto {

    private long subjectId;

    private String color;

    private UserDto teacher;

    private List<UnitDto> units;

    private List<UserDto> students;
}