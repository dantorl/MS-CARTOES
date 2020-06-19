package com.cartao.client;

import com.cartao.exceptions.CartaoAlreadyExistsException;
import com.cartao.exceptions.ClienteNotFoundException;
import com.cartao.exceptions.ClienteOfflineException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ClienteClientErrorDecoder implements ErrorDecoder {
    //Classe responsável por decodificar o erro retornado ao chamar a API de CLIENT
    // Ideal centralizar os tramentos de erro de regra de negócios aqui


    private ErrorDecoder errorDecoder = new ErrorDecoder.Default();

    @Override
    public Exception decode(String s, Response response) {
        if(response.status() == 400) {
            return new ClienteNotFoundException();
        }else {
                return errorDecoder.decode(s, response);

        }
    }
}
