package br.com.nicolas.workshopsb.domain.entities;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private UUID id;

  private String name;

  private String email;

  private String phone;

  private String password;

}
