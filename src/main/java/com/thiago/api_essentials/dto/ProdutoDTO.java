package com.thiago.api_essentials.dto;

import com.thiago.api_essentials.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoDTO {
    @NotBlank
    private String nome;
    @NotNull
    private BigDecimal preco;
    @NotNull
    private Integer quantidade;
    @NotBlank
    private Role role;
}
