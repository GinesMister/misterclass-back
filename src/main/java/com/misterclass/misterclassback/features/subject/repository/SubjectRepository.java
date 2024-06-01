package com.misterclass.misterclassback.features.subject.repository;

import com.misterclass.misterclassback.features.subject.model.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
    @Query("SELECT CASE WHEN COUNT(su) > 0 THEN true ELSE false END FROM SubjectEntity su WHERE su.accessCode = :code")
    boolean existSubjectByCode(@Param("code") String code);

    @Query("SELECT s FROM SubjectEntity s WHERE s.teacher.userId = :id")
    List<SubjectEntity> getSubjectsByTeacherId(@Param("id") String id);
}