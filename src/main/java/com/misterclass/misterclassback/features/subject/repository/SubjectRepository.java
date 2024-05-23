package com.misterclass.misterclassback.features.subject.repository;

import com.misterclass.misterclassback.features.subject.model.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}