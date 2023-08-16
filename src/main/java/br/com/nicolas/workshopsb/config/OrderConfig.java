package br.com.nicolas.workshopsb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import br.com.nicolas.workshopsb.domain.repositories.OrderRepository;
import br.com.nicolas.workshopsb.domain.services.OrderService;

@Configuration
@EnableJpaAuditing
public class OrderConfig {
  
  @Bean
  OrderService orderService(OrderRepository orderRepository){
    return new OrderService(orderRepository);
  }
}
