package com.misterclass.misterclassback.features.subject.mapper;

import com.misterclass.misterclassback.features.subject.dto.subject.SimplifiedSubjectDto;
import com.misterclass.misterclassback.features.subject.dto.subject.SubjectDto;
import com.misterclass.misterclassback.features.subject.model.SubjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {UnitMapper.class})
public interface SubjectMapper {

    SubjectDto entityToDto(SubjectEntity subjectEntity);

    SubjectEntity dtoToEntity(SubjectDto subjectDto);

    List<SubjectDto> entityListToDtoList(List<SubjectEntity> subjectEntityList);

    @Mapping(source = "teacher.userId", target = "teacherId")
    SimplifiedSubjectDto entityToSimplifiedDto(SubjectEntity subjectEntity);

    @Mapping(source = "teacherId", target = "teacher.userId")
    SubjectEntity simplifiedDtoToEntity(SimplifiedSubjectDto simplifiedSubjectDto);

    List<SimplifiedSubjectDto> entityListToSimplifiedDtoList(List<SubjectEntity> subjectEntityList);
}
