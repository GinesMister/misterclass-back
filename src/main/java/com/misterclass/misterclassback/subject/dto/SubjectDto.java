package com.misterclass.misterclassback.subject.dto;

import com.misterclass.misterclassback.user.dto.UserDto;
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