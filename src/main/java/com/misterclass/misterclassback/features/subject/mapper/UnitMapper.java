package com.misterclass.misterclassback.features.subject.mapper;

import com.misterclass.misterclassback.features.subject.dto.unit.CreateUnitRequestDto;
import com.misterclass.misterclassback.features.subject.dto.unit.UnitDto;
import com.misterclass.misterclassback.features.subject.model.UnitEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TheoryElementMapper.class, TaskMapper.class})
public interface UnitMapper {

    UnitDto entityToDto(UnitEntity unitEntity);

    UnitEntity dtoToEntity(UnitDto unitDto);

    List<UnitDto> entityListToDtoList(List<UnitDto> unitDtoList);

    CreateUnitRequestDto createDtoToDto(CreateUnitRequestDto createUnitRequestDto);
}
