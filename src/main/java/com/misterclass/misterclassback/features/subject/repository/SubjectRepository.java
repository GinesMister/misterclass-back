package com.misterclass.misterclassback.features.subject.repository;

import com.misterclass.misterclassback.features.subject.model.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
    @Query("SELECT CASE WHEN COUNT(su) > 0 THEN true ELSE false END FROM SubjectEntity su WHERE su.accessCode = :code")
    boolean existSubjectByCode(@Param("code") String code);

    // TODO getSubjectCreatedByUserId
}