package com.thiago.api_essentials.database.repository;

import com.thiago.api_essentials.database.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<ProdutoEntity,Long> {

}
