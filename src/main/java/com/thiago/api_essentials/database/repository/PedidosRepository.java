package com.thiago.api_essentials.database.repository;

import com.thiago.api_essentials.database.model.PedidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<PedidosEntity, Long> {
}
