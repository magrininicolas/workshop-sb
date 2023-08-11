package br.com.nicolas.workshopsb.web.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nicolas.workshopsb.api.dto.UserResponseDTO;
import br.com.nicolas.workshopsb.domain.entities.User;
import br.com.nicolas.workshopsb.domain.services.UserService;
import br.com.nicolas.workshopsb.web.maps.UserMapper;

@RestController
@RequestMapping("/users")
public class UserController {

  private UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<UserResponseDTO>> findAllUsers() {
    List<User> users = service.findAll();
    return ResponseEntity
        .ok()
        .body(users
            .parallelStream()
            .map(UserMapper::fromUserToUserResponseDTO).toList());
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDTO> findUserById(@PathVariable(name = "id") UUID id) {
    User user = service.findById(id);
    return ResponseEntity.ok().body(UserMapper.fromUserToUserResponseDTO(user));
  }
}
