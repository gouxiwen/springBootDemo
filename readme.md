# Spring Boot Demo 项目

一个使用 Spring Boot 开发的 Web 应用示例项目，采用分层架构设计，展示了控制器、服务、仓储等的最佳实践。

## 项目架构

```
springBootDemo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/demo/
│   │   │       ├── config/              # 配置类
│   │   │       ├── controller/          # 控制器层（API端点）
│   │   │       ├── service/             # 业务逻辑层
│   │   │       ├── repository/          # 数据访问层
│   │   │       ├── entity/              # 实体类（数据模型）
│   │   │       └── DemoApplication.java # 应用启动类
│   │   └── resources/
│   │       ├── application.yml          # 主配置文件
│   │       ├── application-dev.yml      # 开发环境配置
│   │       └── application-prod.yml     # 生产环境配置
│   └── test/
│       └── java/
│           └── com/example/demo/        # 单元测试代码
├── pom.xml                              # Maven 依赖配置
├── mvnw & mvnw.cmd                      # Maven 包装脚本
└── readme.md                            # 项目文档
```

## 技术栈

- **框架**: Spring Boot
- **数据库**: 支持多种数据库配置
- **构建工具**: Maven
- **Java 版本**: 8+

## 快速开始

### 前置要求

- Java 8 或更高版本
- Maven 3.6 或更高版本

### vscode 插件

extension pack for java，由六个包组成

### maven 配置

主要配置下载镜像地址和存储位置

1. 全局安装配置在安装目录的 conf/setting.xml 中

2. vscode 插件（extension pack for java，包含六个包）其中两个包需要配置 maven
   language support for java 在 java.configuration.maven.globalSettings 中配置
   maven for java 在 maven.settingsFile 中配置

### 构建项目

mvn 可以是全局安装的也可以是是项目内安装的，一般 spring boot 项目内会附带 mvn。

存储位置配置

```bash
# 使用 Maven 构建
mvn clean package

# 或使用 Maven 包装脚本（Windows）cmd
mvnw.cmd clean package

# 或使用 Maven 包装脚本（Windows）powerShell
mvnw clean package

# 或使用 Maven 包装脚本（Linux/Mac）
./mvnw clean package
```

Maven 的 package 和 install 命令核心区别在于：‌package 仅负责将项目编译、测试并打包成 JAR/WAR 文件，输出到项目的 target 目录；而 install 在 package 的基础上，还会将打包好的文件安装到本地 Maven 仓库（通常位于用户目录下的 .m2/repository），供其他项目依赖使用 ‌。‌‌

### 运行应用

```bash
# 使用 Maven 启动
mvn spring-boot:run

# 或使用 Maven 包装脚本（Windows）cmd
mvnw.cmd spring-boot:run

# 或使用 Maven 包装脚本（Windows）powerShell
mvnw spring-boot:run

# 或使用 Maven 包装脚本（Linux/Mac）
./mvnw spring-boot:run
```

应用启动后，访问 `http://localhost:9090`

## 模块说明

| 模块       | 说明                        |
| ---------- | --------------------------- |
| config     | 应用配置类，包括 JPA 配置等 |
| controller | Web 控制器，处理 HTTP 请求  |
| service    | 业务逻辑层，处理核心业务    |
| repository | 数据访问层，操作数据库      |
| entity     | JPA 实体类，数据库模型      |

## 环境配置

项目支持多环境配置：

- `application.yml` - 默认配置
- `application-dev.yml` - 开发环境配置
- `application-prod.yml` - 生产环境配置

### 切换环境

在 `application.yml` 中配置：

```yaml
spring:
  profiles:
    active: dev # 或 prod
```

## 参考资源

- [Spring Boot 官方文档](https://spring.io/projects/spring-boot)
- [Spring Data JPA 文档](https://spring.io/projects/spring-data-jpa)
- [Imooc Spring Boot 教程](https://www.imooc.com/article/370327)

## 许可证

MIT License
