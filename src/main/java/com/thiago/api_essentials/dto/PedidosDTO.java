package com.thiago.api_essentials.dto;

import com.thiago.api_essentials.database.model.ProdutoEntity;
import com.thiago.api_essentials.database.model.UserEntity;
import com.thiago.api_essentials.enums.StatusEnum;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PedidosDTO {
    private StatusEnum status;
    private Double valorTotal;
    private Integer quantidadeItens;
    private UUID clienteId;
    private List<Long> produtosIds;
}
