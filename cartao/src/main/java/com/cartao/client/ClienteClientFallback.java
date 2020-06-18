package com.cartao.client;

import com.netflix.client.ClientException;

import java.io.IOException;

public class ClienteClientFallback implements ClienteClient{
    private Exception cause;

    ClienteClientFallback(Exception cause) {
        this.cause = cause;
    }

    @Override
    public ClienteDTO getById(Integer id) {
        if(cause instanceof RuntimeException) {
            throw new RuntimeException("O serviço de carro está offline");
        }
        System.out.println(cause.getCause());
        // Cliente fake
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(-99);
        clienteDTO.setName(cause.getClass().getName());
        return clienteDTO;
    }
}
