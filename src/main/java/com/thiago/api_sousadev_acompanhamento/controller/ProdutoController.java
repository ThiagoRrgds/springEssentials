package com.thiago.api_sousadev_acompanhamento.controller;

import com.thiago.api_sousadev_acompanhamento.database.model.ProdutoModel;
import com.thiago.api_sousadev_acompanhamento.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }
}
