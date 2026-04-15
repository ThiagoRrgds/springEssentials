package com.thiago.api_essentials.service;

import com.thiago.api_essentials.database.model.PedidosEntity;
import com.thiago.api_essentials.database.model.ProdutoEntity;
import com.thiago.api_essentials.database.model.UserEntity;
import com.thiago.api_essentials.database.repository.PedidosRepository;
import com.thiago.api_essentials.database.repository.ProdutoRepository;
import com.thiago.api_essentials.database.repository.UserRepository;
import com.thiago.api_essentials.dto.PedidosDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidosService {
    private final PedidosRepository pedidosRepository;
    private final UserRepository userRepository;
    private final ProdutoRepository produtoRepository;

    public List<PedidosEntity> findAll(){
        return pedidosRepository.findAll();
    }

    public PedidosEntity createPedido(PedidosDTO pedidosDTO){
        UserEntity cliente = userRepository.findById(pedidosDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("cliete não encontrado"));

        List<ProdutoEntity> protudos = produtoRepository.findAllById(pedidosDTO.getProdutosIds());

        PedidosEntity novopedido = PedidosEntity.builder()
                .status(pedidosDTO.getStatus())
                .valorTotal(pedidosDTO.getValorTotal())
                .cliente(cliente)
                .quantidadeItens(pedidosDTO.getQuantidadeItens())
                .produto(protudos)
                .build();

        return pedidosRepository.save(novopedido);
    }

}
