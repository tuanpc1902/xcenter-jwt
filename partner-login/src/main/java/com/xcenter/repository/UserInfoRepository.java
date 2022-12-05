package com.xcenter.repository;

import com.xcenter.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
  Optional<UserInfo> findByUsername(String username);

  UserInfo getUserInfoByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
