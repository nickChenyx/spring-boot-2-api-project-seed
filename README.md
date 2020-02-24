# 基于 SpringBoot 2 搭建的种子项目

> 基于此项目，你可以快速构建一个 web 项目原型

## Quick Start

路径一（无需数据库）：
1. 启动 ApiApplication.java
2. 访问 "localhost:10000/test/str" 接口返回 "str"

路径二（含数据库）：
1. 使用你自己的 Mysql 服务器，新建 accoun 库并执行 schema.sql 中的 sql
2. 修改 application-dev.properties 中的 mysql 连接参数
3. 启动 ApiApplication.java
4. 访问 "localhost:10000/test/str" 接口返回 "str"
5. 访问 "localhost:10000/test/str" 接口返回数据库结果（此时控制台会打印 SQL 分析日志）

注，文件地址：
- spring-boot-2-api-project-seed/persistence/src/test/resources/schema.sql
- spring-boot-2-api-project-seed/api/src/main/resources/application-dev.properties

## 项目介绍

项目结构按照个人理解，结合业务上的思考整理而成。对于项目结构上有疑问的欢迎在 issue 中讨论。

### 项目结构

项目目前简要分为三个模块

- persistence —— 持久层
- common-service —— 通用业务层
- api —— 网络接口层

#### persistence 层

持久层只负责有关持久化的**依赖**、**配置**、**实体**、**SQL**等信息，可以独立启动，进行持久层的单元测试。

以下皆以 MySQL 作为数据源为例：

- 依赖：MySQL JDBC connector、spring boot jdbc 等依赖
- 配置：MySQL 相关的链接参数，Mybatis Plus 相关配置
- 实体：数据库表的实体映射
- SQL：基于 Mapper 的 SQL xml 文件

#### common-service 层

通用业务层负责处理业务逻辑，也就是通常说的 service 层。此层也负责非 web 相关的组件**配置**，例如 Redis 的链接信息等等。

#### api 层

网络接口层，常用于封装 RESTful 风格的 接口，提供给调用方访问。此层也负责配置 web 相关的**配置**，如 tomcat 连接数、响应结果的序列化配置等等。

### 常用工具

**CodeGenerator.java** 用于生成代码，注意代码生成的路径并不符合项目结构，需要自己移动下生成的类到指定项目结构。[文档地址](https://mp.baomidou.com/guide/generator.html)

**spy.properties** 默认 dev 环境 SQL 执行分析工具的配置文件，结合 Mybatis-Plus 可以实现 dev 环境的 SQL 执行分析。[文档地址](https://mp.baomidou.com/guide/performance-analysis-plugin.html)

## 鸣谢

感谢以下开源框架的贡献（排名不分先后）：
- [Mybatis-Plus](https://github.com/baomidou/mybatis-plus)
- [Hutool](https://hutool.cn/)
- [lombok](https://projectlombok.org/)
- [p6spy](https://github.com/p6spy/p6spy)
- [Guava](https://github.com/google/guava)
- [SpringBoot](https://spring.io/)
