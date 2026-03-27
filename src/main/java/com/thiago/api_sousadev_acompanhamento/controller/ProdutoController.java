package com.thiago.api_sousadev_acompanhamento.controller;

import com.thiago.api_sousadev_acompanhamento.database.model.ProdutoEntity;
import com.thiago.api_sousadev_acompanhamento.dto.ProdutoDto;
import com.thiago.api_sousadev_acompanhamento.exception.NotFoundException;
import com.thiago.api_sousadev_acompanhamento.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoEntity>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @PostMapping
    public ResponseEntity<ProdutoEntity> createProduct(@RequestBody ProdutoDto produtoDto) {
        ProdutoEntity produto = produtoService.createProduct(produtoDto);
        return ResponseEntity.created(URI.create("/v1/produtos/" + produto.getId()))
                .body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> updateProduct(@RequestBody ProdutoDto produtoDto, @PathVariable Long id) throws NotFoundException {
       ProdutoEntity produto = produtoService.updateProduct(produtoDto, id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) throws NotFoundException {
        produtoService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
