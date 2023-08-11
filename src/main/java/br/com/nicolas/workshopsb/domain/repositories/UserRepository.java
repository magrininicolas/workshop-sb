package br.com.nicolas.workshopsb.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nicolas.workshopsb.domain.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {
  
}
