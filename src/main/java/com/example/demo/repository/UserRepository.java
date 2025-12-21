package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  // 根据用户名查找用户
  Optional<User> findByName(String name);

  // 根据邮箱查找用户
  Optional<User> findByEmail(String email);

  // 自定义查询：查找创建时间在指定时间之后的用户
  @Query("SELECT u FROM User u WHERE u.createTime > :createTime")
  List<User> findUsersAfterCreateTime(@Param("createTime") LocalDateTime createTime);

  // 检查用户名是否存在
  boolean existsByName(String name);

  // 检查邮箱是否存在
  boolean existsByEmail(String email);
}
