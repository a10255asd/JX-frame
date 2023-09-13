# JX-frame
基于SpringBoot开发的轻量级框架

### 设置阿里镜像

### 集成 springboot

### 集成 springmvc

### 服务模块拆解
webmvc 拆解

### lombok

### 集成数据库连接池

### 集成 mybatis plus
po 严格和数据库做交互
dto 可以包含很多po集成
使用 handler 解决每次都要写createBy，updateBy等问题

### 集成 druid 监控

### 集成 mybatis 优化器 

### mybatis 优化器自动装载

### 没有把提示的实体类优化

### 全局异常捕获

### mybatisplus 提供的拦截器集成

### 分页查询

### 集成mapstruct

### 集成swagger

### 集成redistemplate

### 处理默认序列化乱码问题

### 封装redisUtil

### 项目启动自动预热缓存

### 封装分布式锁

### 注解缓存的方式
分布式锁业务场景: 
01、在不集成xxljob的情况下，进行任务调度
02、计算金额的场景，操作统一数据。例如：数据库查出 ¥1000 计算后 ¥1200
总结：操作同一数据。
### 注解缓存的方式
不建议使用，因为无法根据key设置key的过期时间，会导致所有key同时过期。会有缓存雪崩的问题。

### 日志log4j集成，异步日志集成
