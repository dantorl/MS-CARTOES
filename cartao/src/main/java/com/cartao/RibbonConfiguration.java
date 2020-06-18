package com.cartao;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {
    //Essa classe não é obrigatória, pois o Feign já utiliza o Ribbon automaticamente, porém com configurações default
    //Neste caso, podemos criar essa classe para alterar as configurações do Ribbon
    //Essa configuração para ser utilizada, deve ser decarada no Aplication(CartaoApplication) ou no client;


    @Bean
    public IRule iRule() {
        //Metodo que sobrescreve a regra de distribuição de carga
        return new RandomRule();
        //Essa opção(RandomRule) faz com que o Ribbon distribua a carga de forma randomica,
        //sem isso o Ribbon iria utilizar a regra default que é distribuição por igual entre os servidores(RoundRobinRule)
    }

}
