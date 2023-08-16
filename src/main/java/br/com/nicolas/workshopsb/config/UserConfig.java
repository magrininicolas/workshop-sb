package br.com.nicolas.workshopsb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import br.com.nicolas.workshopsb.domain.repositories.UserRepository;
import br.com.nicolas.workshopsb.domain.services.UserService;

@Configuration
@EnableJpaAuditing
public class UserConfig {
  
  @Bean
  UserService userService(UserRepository userRepository){
    return new UserService(userRepository);
  }
}
