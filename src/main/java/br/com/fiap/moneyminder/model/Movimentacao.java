package br.com.fiap.moneyminder.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Movimentacao {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        
    @NotBlank @Size( min = 3)
    private String descricao;

    @Positive
    private BigDecimal valor;

    private LocalDate data; 
    
    // @TipoMovimentacao
    private String tipo; // ENTRADA | SAIDA
    
}

