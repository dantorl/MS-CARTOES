package com.pagamento.client;

import com.pagamento.exceptions.CartaoNotFoundException;
import com.pagamento.exceptions.CartaoOffilineException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CartaoClientErrorDecoder implements ErrorDecoder {
    private ErrorDecoder errorDecoder = new ErrorDecoder.Default();

    @Override
    public Exception decode(String s, Response response) {
        if(response.status() == 400) {
            return new CartaoNotFoundException();
        }else{

                return errorDecoder.decode(s, response);
            }
    }
}
