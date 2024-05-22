package com.misterclass.misterclassback.user.repository;

import com.misterclass.misterclassback.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
