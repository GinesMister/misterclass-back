package com.misterclass.misterclassback.features.user.repository;

import com.misterclass.misterclassback.features.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
