package br.com.nicolas.workshopsb.domain.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.nicolas.workshopsb.domain.entities.User;
import br.com.nicolas.workshopsb.domain.repositories.UserRepository;

@Service
public class UserService {

  private UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(UUID id) {
    return repository.findById(id).orElse(null);
  }
}
