package br.com.itau.teste.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutomovelResponse {

    private String marca;
    private String modelo;
    private BigDecimal valor;
    private LocalDateTime dataCadastro;
}
