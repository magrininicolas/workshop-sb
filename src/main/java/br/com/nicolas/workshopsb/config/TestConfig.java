package br.com.nicolas.workshopsb.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.nicolas.workshopsb.domain.entities.User;
import br.com.nicolas.workshopsb.domain.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  private UserRepository repository;

  public TestConfig(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public void run(String... args) throws Exception {
    User u1 = new User(null, "Maria Brown", "maria@gmail.com", "9888888", "123456");
    User u2 = new User(null, "Alex Green", "alex@gmail.com", "9999999", "123456");

    repository.saveAll(Arrays.asList(u1, u2));
  }

}
