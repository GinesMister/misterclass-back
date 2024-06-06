package com.misterclass.misterclassback.features.subject.repository;


import com.misterclass.misterclassback.features.subject.model.TaskEntity;
import com.misterclass.misterclassback.features.subject.model.UnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
