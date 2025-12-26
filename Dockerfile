# 多阶段构建 - 第一阶段：构建应用
FROM maven:3.8-openjdk-17-slim AS builder

# 设置工作目录
WORKDIR /app

# 配置 Maven 使用阿里云镜像
COPY settings.xml /root/.m2/settings.xml

# 复制 Maven 配置文件
COPY pom.xml .

# 下载依赖并缓存，利用 Docker 层缓存
RUN mvn dependency:go-offline -B

# 复制源代码
COPY src ./src

# 构建应用并优化 JAR
RUN mvn clean package -DskipTests &&     mkdir -p target/dependency &&     (cd target/dependency; jar -xf ../*.jar)

# 第二阶段：运行应用
FROM eclipse-temurin:17-jre-alpine-3.23

# 安装必要的工具
RUN apk add --no-cache tzdata curl &&     ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

# 设置工作目录
WORKDIR /app

# 从构建阶段复制 JAR 文件
COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# 端口
EXPOSE 9090

# 添加应用用户，提高安全性
RUN addgroup --system spring && adduser --system spring --ingroup spring

# 更改文件所有者
RUN chown -R spring:spring /app
USER spring

# 设置 JVM 参数，优化内存使用和 GC
ENV JAVA_OPTS="-Xms256m -Xmx512m -XX:+UseG1GC -XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# 健康检查
HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3     CMD curl -f http://localhost:9090/actuator/health || exit 1

# 启动应用
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
