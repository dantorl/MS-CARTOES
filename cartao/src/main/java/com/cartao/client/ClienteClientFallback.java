package com.cartao.client;

import com.cartao.exceptions.ClienteOfflineException;
import com.netflix.client.ClientException;

import java.io.IOException;
import java.net.ConnectException;

public class ClienteClientFallback implements ClienteClient{
    private Exception cause;

    ClienteClientFallback(Exception cause) {
        this.cause = cause;
    }

    @Override
    public ClienteDTO getById(Integer id) {

         if(cause instanceof IOException || cause instanceof ConnectException || cause instanceof ClientException || cause.getLocalizedMessage() != null)  {

            throw new ClienteOfflineException();
            //throw (RuntimeException) cause;
        }
        throw (RuntimeException) cause;
    }
}
