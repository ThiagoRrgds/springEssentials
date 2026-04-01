package com.thiago.api_essentials.database.model;

import com.thiago.api_essentials.enums.StatusEnum;
import jakarta.persistence.*;


@Entity
@Table(name = "pedidos")
public class PedidosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private UserEntity cliente;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnum status;
}
