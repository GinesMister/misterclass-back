package com.misterclass.misterclassback.features.subject.mapper;

import com.misterclass.misterclassback.features.subject.dto.subject.SimplifiedSubjectDto;
import com.misterclass.misterclassback.features.subject.dto.subject.SubjectDto;
import com.misterclass.misterclassback.features.subject.model.SubjectEntity;
import com.misterclass.misterclassback.features.user.mapper.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {UnitMapper.class})
public interface SubjectMapper {

    SubjectDto entityToDto(SubjectEntity subjectEntity);

    SubjectEntity dtoToEntity(SubjectDto subjectDto);

    List<SubjectDto> entityListToDtoList(List<SubjectEntity> subjectEntityList);

    SimplifiedSubjectDto entityToSimplifiedDto(SubjectEntity subjectEntity);

    SubjectEntity simplifiedDtoToEntity(SimplifiedSubjectDto simplifiedSubjectDto);

    List<SimplifiedSubjectDto> entityListToSimplifiedDtoList(List<SubjectEntity> subjectEntityList);
}
