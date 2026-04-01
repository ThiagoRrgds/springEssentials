package com.thiago.api_sousadev_acompanhamento.database.repository;

import com.thiago.api_sousadev_acompanhamento.database.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
