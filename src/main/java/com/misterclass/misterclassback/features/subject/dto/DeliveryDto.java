package com.misterclass.misterclassback.features.subject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryDto {

    private long deliveryId;

    private String delivererId;

    private LocalDateTime deliveryDate;

    private String filepath;
}
