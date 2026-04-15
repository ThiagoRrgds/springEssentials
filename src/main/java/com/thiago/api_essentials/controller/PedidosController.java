package com.thiago.api_essentials.controller;

import com.thiago.api_essentials.database.model.PedidosEntity;
import com.thiago.api_essentials.dto.PedidosDTO;
import com.thiago.api_essentials.service.PedidosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pedidos")
@RequiredArgsConstructor
@Validated
public class PedidosController {
    private final PedidosService pedidosService;

    @GetMapping
    public ResponseEntity<List<PedidosEntity>> findAll(){
        return ResponseEntity.ok(pedidosService.findAll());
    }

    @PostMapping
    public ResponseEntity<List<PedidosEntity>> createPedido(@Valid @RequestBody List<PedidosDTO> pedidosDTO){
        List<PedidosEntity> pedidos = pedidosDTO.stream()
                .map(pedidosService::createPedido)
                .toList();

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidos);
    }
}
