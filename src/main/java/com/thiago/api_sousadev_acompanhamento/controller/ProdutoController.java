package com.thiago.api_sousadev_acompanhamento.controller;

import com.thiago.api_sousadev_acompanhamento.database.model.ProdutoModel;
import com.thiago.api_sousadev_acompanhamento.dto.ProdutoDto;
import com.thiago.api_sousadev_acompanhamento.exception.NotFoundException;
import com.thiago.api_sousadev_acompanhamento.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<ProdutoModel>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> createProduct(@RequestBody ProdutoDto produtoDto) {
        ProdutoModel produto = produtoService.createProduct(produtoDto);
        return ResponseEntity.created(URI.create("/v1/produtos/" + produto.getId()))
                .body(produto);
    }

    @PutMapping("/{id}")
    public ProdutoModel updateProduct(@RequestBody ProdutoDto produtoDto, @PathVariable Integer id) throws NotFoundException {
        return produtoService.updateProduct(produtoDto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
         boolean removed = produtoService.deleteProduct(id);
         if (removed) {
             return ResponseEntity.noContent().build();
         } else {
             return ResponseEntity.notFound().build();
         }
    }
}
