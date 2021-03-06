package com.cartao.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cartao")
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 9, max = 9, message = "O número do cartão deve ter 9 digitos")
    private String numero;

    @NotNull
    private Integer clienteId;

    private Boolean ativo;

    public Cartao() {
    }

    public Cartao(Integer id, @NotNull String numero, @NotNull Integer clienteId, Boolean ativo) {
        this.id = id;
        this.numero = numero;
        this.clienteId = clienteId;
        this.ativo = ativo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
