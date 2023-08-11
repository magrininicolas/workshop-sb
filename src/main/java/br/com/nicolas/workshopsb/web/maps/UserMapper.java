package br.com.nicolas.workshopsb.web.maps;

import br.com.nicolas.workshopsb.api.dto.UserResponseDTO;
import br.com.nicolas.workshopsb.domain.entities.User;

public final class UserMapper {

  private UserMapper() {}
  
  public static UserResponseDTO fromUserToUserResponseDTO(User user) {
    return new UserResponseDTO(user.getName(), user.getEmail(), user.getPhone());
  }
}
