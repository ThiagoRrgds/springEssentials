package com.thiago.api_essentials.service;

import com.thiago.api_essentials.database.model.ProdutoEntity;
import com.thiago.api_essentials.database.repository.ProdutoRepository;
import com.thiago.api_essentials.dto.ProdutoDto;
import com.thiago.api_essentials.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
        private final ProdutoRepository produtoRepository;
        private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>();

        public List<ProdutoEntity> findAll() {
            return new ArrayList<>(PRODUTOS);
        }

        public ProdutoEntity createProduct(ProdutoDto produtoDto){
            ProdutoEntity novoProduto = ProdutoEntity.builder()
                    .nome(produtoDto.getNome())
                    .preco(produtoDto.getPreco())
                    .quantidade(produtoDto.getQuantidade())
                    .build();
            return produtoRepository.save(novoProduto);
        }


        public ProdutoEntity updateProduct(ProdutoDto produtoDto, Long id) throws NotFoundException {
            ProdutoEntity produto =  produtoRepository.findById(id)
                    .orElseThrow(() ->new NotFoundException("produto não encontrado"));
            produto.setNome(produtoDto.getNome());
            produto.setPreco(produtoDto.getPreco());
            produto.setQuantidade(produtoDto.getQuantidade());

            return produtoRepository.save(produto);
        }

        public void deleteProduct(Long id) throws NotFoundException {
            if (!produtoRepository.existsById(id)){
                throw new NotFoundException("produto não encontrado");
            }
            produtoRepository.deleteById(id);
        }

}
