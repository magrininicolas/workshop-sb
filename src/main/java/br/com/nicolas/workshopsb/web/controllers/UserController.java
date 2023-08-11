package br.com.nicolas.workshopsb.web.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nicolas.workshopsb.api.dto.UserResponseDTO;
import br.com.nicolas.workshopsb.domain.entities.User;
import br.com.nicolas.workshopsb.web.controllers.maps.UserMapper;

@RestController
@RequestMapping("/users")
public class UserController {

  @GetMapping
  public ResponseEntity<UserResponseDTO> findAll() {
    User user = new User(UUID.randomUUID(), "Name", "Email", "Phone", "123");
    UserResponseDTO userResponseDTO = UserMapper.fromUserToUserResponseDTO(user);
    return ResponseEntity.ok().body(userResponseDTO);
  }
}
