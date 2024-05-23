package com.misterclass.misterclassback.features.subject.mapper;

import com.misterclass.misterclassback.features.subject.dto.SubjectDto;
import com.misterclass.misterclassback.features.subject.model.SubjectEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {UnitMapper.class})
public interface SubjectMapper {

    SubjectDto entityToDto(SubjectEntity subjectEntity);

    SubjectEntity dtoToEntity(SubjectDto subjectDto);

    List<SubjectDto> entityListToDtoList(List<SubjectEntity> subjectEntityList);

}