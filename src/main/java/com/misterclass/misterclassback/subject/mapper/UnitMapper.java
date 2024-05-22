package com.misterclass.misterclassback.subject.mapper;

import com.misterclass.misterclassback.subject.dto.UnitDto;
import com.misterclass.misterclassback.subject.model.UnitEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TheoryElementMapper.class, TaskMapper.class})
public interface UnitMapper {

    UnitDto entityToDto(UnitEntity unitEntity);

    UnitEntity dtoToEntity(UnitDto unitDto);

    List<UnitDto> entityListToDtoList(List<UnitDto> unitDtoList);
}
