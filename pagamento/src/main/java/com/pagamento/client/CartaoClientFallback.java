package com.pagamento.client;

import com.netflix.client.ClientException;
import com.pagamento.exceptions.CartaoOffilineException;

import java.io.IOException;
import java.net.ConnectException;

public class CartaoClientFallback implements CartaoClient {

    private Exception cause;

    CartaoClientFallback(Exception cause) {
        this.cause = cause;
    }

    @Override
    public CartaoDTO getById(Integer id) {


        if(cause instanceof IOException || cause instanceof ConnectException || cause instanceof ClientException || cause.getLocalizedMessage() != null)  {

            throw new CartaoOffilineException();
            //throw (RuntimeException) cause;
        }
        throw (RuntimeException) cause;
    }
}
