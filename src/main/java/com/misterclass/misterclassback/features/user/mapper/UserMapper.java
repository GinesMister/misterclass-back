package com.misterclass.misterclassback.features.user.mapper;

import com.misterclass.misterclassback.features.subject.mapper.SubjectMapper;
import com.misterclass.misterclassback.features.user.dto.UserDto;
import com.misterclass.misterclassback.features.user.model.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SubjectMapper.class})
public interface UserMapper {

    UserDto entityToDto(UserEntity userEntity);

    UserEntity dtoToEntity(UserDto userDto);

    List<UserDto> entityListToDtoList(List<UserEntity> userEntityList);
}
