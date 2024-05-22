package com.misterclass.misterclassback.subject.repository;

import com.misterclass.misterclassback.subject.model.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}