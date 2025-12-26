package com.example.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Schema(description = "用户实体类")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "用户ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY, hidden = true)
  private Long id;

  @Schema(description = "用户名", example = "张三")
  private String name;

  @Schema(description = "用户邮箱", example = "zhangsan@example.com")
  private String email;

  @Schema(description = "创建时间", accessMode = Schema.AccessMode.READ_ONLY, hidden = true)
  private LocalDateTime createTime;

  // 构造函数
  public User() {
  }

  public User(String name, String email) {
    this.name = name;
    this.email = email;
    this.createTime = LocalDateTime.now();
  }

  // getter 和 setter
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }
}
