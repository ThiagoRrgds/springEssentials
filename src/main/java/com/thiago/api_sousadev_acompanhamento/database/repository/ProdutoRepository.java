package com.thiago.api_sousadev_acompanhamento.database.repository;

import com.thiago.api_sousadev_acompanhamento.database.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity,Long> {

}
