package br.com.nicolas.workshopsb.api.dto;

import java.time.Instant;

import br.com.nicolas.workshopsb.domain.entities.User;

public record OrderResponseDTO(Instant instant, User client) {
  
}
