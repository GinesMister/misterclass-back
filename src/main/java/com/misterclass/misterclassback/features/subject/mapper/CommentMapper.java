package com.misterclass.misterclassback.features.subject.mapper;

import com.misterclass.misterclassback.features.subject.dto.CommentDto;
import com.misterclass.misterclassback.features.subject.model.CommentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDto entityToDto(CommentEntity commentEntity);

    CommentEntity dtoToEntity(CommentDto commentDto);

    List<CommentDto> entityListToDtoList(List<CommentEntity> commentEntityList);
}
