package com.misterclass.misterclassback.subject.mapper;

import com.misterclass.misterclassback.subject.dto.CommentDto;
import com.misterclass.misterclassback.subject.dto.TheoryElementDto;
import com.misterclass.misterclassback.subject.model.TheoryElementEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CommentDto.class})
public interface TheoryElementMapper {

    TheoryElementDto entityToDto(TheoryElementEntity theoryElementEntity);

    TheoryElementEntity dtoToEntity(TheoryElementDto theoryElementDto);

    List<TheoryElementDto> entityListToDtoList(List<TheoryElementEntity> theoryElementEntityList);
}
