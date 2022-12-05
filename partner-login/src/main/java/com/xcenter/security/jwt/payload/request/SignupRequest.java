package com.xcenter.security.jwt.payload.request;

import com.xcenter.enums.ELevel;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignupRequest {
  @NotBlank
  @Size(min = 2, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private ELevel level;

  @NotBlank
  @Size(min = 6, max = 100)
  private String password;

}
