package com.misterclass.misterclassback.features.subject.mapper;

import com.misterclass.misterclassback.features.subject.dto.DeliveryDto;
import com.misterclass.misterclassback.features.subject.model.DeliveryEntity;
import com.misterclass.misterclassback.features.user.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDto.class})
public interface DeliveryMapper {

    @Mapping(source = "deliverer.userId", target = "delivererId")
    DeliveryDto entityToDto(DeliveryEntity deliveryEntity);

    @Mapping(source = "delivererId", target = "deliverer.userId")
    DeliveryEntity dtoToEntity(DeliveryDto deliveryDto);

    List<DeliveryDto> entityListToDtoList(List<DeliveryEntity> deliveryEntityList);
}
