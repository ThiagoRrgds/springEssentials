package com.thiago.api_essentials.database.model;

import com.thiago.api_essentials.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "pedidos")
public class PedidosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnum status;
    @Column(nullable = false)
    private Double valorTotal;
    @Column(nullable = false)
    private Integer quantidadeItens;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private UserEntity cliente;
    @ManyToMany
    private List<ProdutoEntity> produto;
}

