package com.xcenter.models;

import com.xcenter.enums.ELevel;
import com.xcenter.enums.EStatus;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user_info",
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
@Data
public class UserInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "userId", nullable = false)
  private Long userId;

  @NotBlank
  private String username;

  @NotBlank
  private String password;

  private String photo;

  private String phone;

  private String email;

  @Enumerated(EnumType.STRING)
  private ELevel levelName;

  private String securityCode;

  private int loginFailCount;

//  private String lastLoginIP;

  @Enumerated(EnumType.STRING)
  private EStatus status;

  public UserInfo() {
  }

  public UserInfo(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

}
