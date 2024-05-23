package com.misterclass.misterclassback.features.subject.mapper;

import com.misterclass.misterclassback.features.subject.dto.CommentDto;
import com.misterclass.misterclassback.features.subject.dto.TaskDto;
import com.misterclass.misterclassback.features.subject.model.TaskEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CommentDto.class})
public interface TaskMapper {

    TaskDto entityToDto(TaskEntity taskEntity);

    TaskEntity dtoToEntity(TaskDto taskDto);

    List<TaskDto> entityListToDtoList(List<TaskEntity> taskEntityList);
}
