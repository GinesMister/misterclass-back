package com.misterclass.misterclassback.features.subject.repository;

import com.misterclass.misterclassback.features.subject.model.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Long> {
}
