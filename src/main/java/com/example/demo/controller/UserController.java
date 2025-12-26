package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Tag(name = "用户管理", description = "用户信息的增删改查操作")
public class UserController {

  private final UserService userService;

  /**
   * 构造器注入 - 推荐方式
   */
  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  @Operation(summary = "获取所有用户", description = "返回系统中所有用户的列表")
  public List<User> getAllUsers() {
    return userService.findAllUsers();
  }

  @GetMapping("/{id}")
  @Operation(summary = "根据ID获取用户", description = "根据提供的ID获取特定用户信息")
  public ResponseEntity<User> getUserById(@Parameter(description = "用户ID") @PathVariable Long id) {
    Optional<User> user = userService.findUserById(id);
    return user.map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @Operation(summary = "创建新用户", description = "根据提供的用户信息创建新用户")
  public User createUser(@Parameter(description = "要创建的用户信息") @RequestBody User user) {
    return userService.saveUser(user);
  }
}
