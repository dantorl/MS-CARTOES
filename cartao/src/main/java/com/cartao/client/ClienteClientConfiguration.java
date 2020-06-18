package com.cartao.client;

import feign.Feign;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class ClienteClientConfiguration {
    //Classe de configurações do Client;
    //Necessário caso queira utilizar tratamentos diferentes de erros
    //Para ser usada essa classe, a mesma deve ser declarada no Client desejado

    @Bean
    public ErrorDecoder getErrorDecoder() {
        return new ClienteClientErrorDecoder();
    }

    /*@Bean
    public Feign.Builder builder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallbackFactory(ClienteClientFallback::new)
                .build();

        return Resilience4jFeign.builder(decorators);
    }*/
}
