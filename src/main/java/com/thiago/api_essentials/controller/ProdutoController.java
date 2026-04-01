package com.thiago.api_essentials.controller;

import com.thiago.api_essentials.database.model.ProdutoEntity;
import com.thiago.api_essentials.dto.ProdutoDTO;
import com.thiago.api_essentials.exception.NotFoundException;
import com.thiago.api_essentials.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
@Validated
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoEntity>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @PostMapping
    public ResponseEntity<List<ProdutoEntity>> createProduct(@Valid @RequestBody List<ProdutoDTO> produtoDto) {
        List<ProdutoEntity> produtos = produtoDto.stream()
                .map(produtoService::createProduct)
                .toList();
        return ResponseEntity.status(HttpStatus.CREATED).body(produtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> updateProduct(@Valid @RequestBody ProdutoDTO produtoDto, @PathVariable Long id) throws NotFoundException {
       ProdutoEntity produto = produtoService.updateProduct(produtoDto, id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) throws NotFoundException {
        produtoService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
