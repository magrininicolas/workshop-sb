package br.com.nicolas.workshopsb.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.nicolas.workshopsb.domain.entities.Order;
import br.com.nicolas.workshopsb.domain.entities.User;
import br.com.nicolas.workshopsb.domain.repositories.OrderRepository;
import br.com.nicolas.workshopsb.domain.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  private UserRepository userRepository;

  private OrderRepository orderRepository;

  public TestConfig(UserRepository userRepository, OrderRepository orderRepository) {
    this.userRepository = userRepository;
    this.orderRepository = orderRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    User u1 = new User(null, "Maria Brown", "maria@gmail.com", "9888888", "123456");
    User u2 = new User(null, "Alex Green", "alex@gmail.com", "9999999", "123456");

    Order o1 = new Order(null, null, u1);
    Order o2 = new Order(null, null, u2);
    Order o3 = new Order(null, null, u1);

    userRepository.saveAll(Arrays.asList(u1, u2));
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
  }

}
