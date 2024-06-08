package com.misterclass.misterclassback.features.subject.repository;


import com.misterclass.misterclassback.features.subject.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
