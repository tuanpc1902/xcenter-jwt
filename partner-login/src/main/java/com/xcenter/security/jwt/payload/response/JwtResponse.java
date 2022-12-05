package com.xcenter.security.jwt.payload.response;

import com.xcenter.enums.ELevel;
import lombok.Data;

@Data
public class JwtResponse {
  private Long userId;
  private String token;

  private String type = "Bearer";
  private String username;
  private String email;
  private ELevel level;

  public JwtResponse(Long userId, String username, String accessToken, String email, ELevel level) {
    this.userId = userId;
    this.username = username;
    this.email = email;
    this.level = level;
    this.type = this.getType();
    this.token = accessToken;
  }

}
