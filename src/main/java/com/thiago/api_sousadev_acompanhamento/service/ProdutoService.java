package com.thiago.api_sousadev_acompanhamento.service;

import com.thiago.api_sousadev_acompanhamento.database.model.ProdutoModel;
import com.thiago.api_sousadev_acompanhamento.dto.ProdutoDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProdutoService {
        private static final List<ProdutoModel> PRODUTOS = new ArrayList<>();

        static {
            PRODUTOS.add(
                ProdutoModel.builder()
                        .id(1)
                        .nome("Notebook Dell")
                        .preco(new BigDecimal("3500.00"))
                        .quantidade(10)
                        .build()
            );

            PRODUTOS.add(
                    ProdutoModel.builder()
                            .id(2)
                            .nome("Smartphone Samsung")
                            .preco(new BigDecimal("2200.00"))
                            .quantidade(25)
                            .build()
            );

            PRODUTOS.add(
                    ProdutoModel.builder()
                            .id(3)
                            .nome("Fone Bluetooth")
                            .preco(new BigDecimal("300.00"))
                            .quantidade(50)
                            .build()
            );

            PRODUTOS.add(
                    ProdutoModel.builder()
                            .id(4)
                            .nome("Cadeira Gamer")
                            .preco(new BigDecimal("1200.00"))
                            .quantidade(8)
                            .build()
            );

            PRODUTOS.add(
                    ProdutoModel.builder()
                            .id(5)
                            .nome("Mouse Logitech")
                            .preco(new BigDecimal("150.00"))
                            .quantidade(40)
                            .build()
            );
        }

        public List<ProdutoModel> findAll() {
            return new ArrayList<>(PRODUTOS);
        }

        public ProdutoModel createProduct(ProdutoDto produtoDto){
            Integer id = PRODUTOS.stream()
                    .mapToInt(ProdutoModel::getId)
                    .max()
                    .orElse(0) + 1;

            ProdutoModel novoProduto = ProdutoModel.builder()
                    .nome(produtoDto.getNome())
                    .preco(produtoDto.getPreco())
                    .quantidade(produtoDto.getQuantidade())
                    .build();

            PRODUTOS.add(novoProduto);

            return novoProduto;
        }


        public ProdutoModel updateProduct(ProdutoDto produtoDto, Integer id){
            ProdutoModel produto = PRODUTOS.stream()
                    .filter(p -> p.getId().equals(id))
                    .findAny()
                    .orElseThrow(() -> new RuntimeException("produto não encontrado"));

            return produto;
        }

            public boolean deleteProduct(Integer id) {
                PRODUTOS.removeIf(p -> p.getId().equals(id));
                return false;
            }

}
