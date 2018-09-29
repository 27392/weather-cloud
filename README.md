# weather-cloud
    
  ⛅基于Spring-Cloud实现的天气预报微服务
  
  该项目通过很简单的例子一步一步从一个单块架构慢慢改进成微服务架构是入门SpringCloud很好的案例
  
  天气API接口：http://wthrcdn.etouch.cn/weather_mini?citykey=101010100

### 服务列表

   - **天气数据采集服务** `collection-service` 
   - **天气数据API服务**  `data-service`
   - **城市数据API服务**  `city-service`
   - **天气预报服务**     `repoer-service`

### 项目分支

   - **master** 分支为微服务架构
   - **single** 分支为单块架构

### 技术栈

   - **微服务框架**  `springCloud`
   - **服务注册与发现** `eureka`
   - **缓存** `redis`
   - **服务消费**   `feign`
   - **网关** `zuul`
   - **统一配置中心**`springcloud-config`
   
**开发中..............**
    