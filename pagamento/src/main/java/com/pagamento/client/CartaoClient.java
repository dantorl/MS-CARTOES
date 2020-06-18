package com.pagamento.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cartao", configuration = CartaoClientConfiguration.class)
public interface CartaoClient {
    @GetMapping("/cartao/byid/{id}")
    CartaoDTO getById(@PathVariable Integer id);
}
