package com.pagamento.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CartaoClientConfiguration {

    @Bean
    public ErrorDecoder getErrorDecoder() {
        return new CartaoClientErrorDecoder();
    }
}
