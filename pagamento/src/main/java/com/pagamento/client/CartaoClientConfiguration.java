package com.pagamento.client;

import feign.Feign;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class CartaoClientConfiguration {

    @Bean
    public ErrorDecoder getErrorDecoder() {
        return new CartaoClientErrorDecoder();
    }

    @Bean
    public Feign.Builder builder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallbackFactory(CartaoClientFallback::new)
                .build();

        return Resilience4jFeign.builder(decorators);
    }
}
