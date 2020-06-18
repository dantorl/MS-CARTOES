package com.cliente.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 4, max = 100, message = "O nome deve ter no minimo 4 caracteres e no maximo 100")
    @NotNull
    private String name;

    public Cliente() {
    }

    public Cliente(Integer id, @Size(min = 4, max = 100, message = "O nome deve ter no minimo 4 caracteres e no maximo 100") @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
