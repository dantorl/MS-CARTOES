package com.pagamento.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PagamentoRequestDTO {
    private String descricao;

    private Double valor;

    @JsonProperty("cartao_id")
    private Integer idCartao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(Integer idCartao) {
        this.idCartao = idCartao;
    }
}

