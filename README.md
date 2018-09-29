# weather-cloud
    
  ⛅基于Spring-Cloud技术栈实现的天气预报微服务项目
  
  该项目通过天气数据API为数据来源，Redis为数据存储。由SpringBoot单块架构进阶为SpringCloud微服务架构
  
  天气数据API接口：http://wthrcdn.etouch.cn/weather_mini?citykey={城市ID}
  
  
## 目录结构
```
├── city-service                    // 城市数据服务   :8673端口  
│   ├── src/main
│   ├── ├──java/cn/haohaoli/city  
│   ├── ├──resources
├── collection-service              // 天气收集服务   :8677端口
│   ├── src/main
│   ├── ├──java/cn/haohaoli/collenction     
│   ├── ├──resources
├── core-config                     // 配置中心       :8989端口
│   ├── src/main
│   ├── ├──java/cn/haohaoli/zuul  
│   ├── ├──resources
├── core-config-repo                // 统一配置文件
├── core-eureka                     // 注册中心       :8761端口
│   ├── src/main
│   ├── ├──java/com/crossoverJie/sbcuser/
│   ├── ├──resources
├── core-zuul                       // 服务网关       :8765端口
│   ├── src/main
│   ├── ├──com/crossoverJie/request/check
│   ├── ├──resources
├── data-service                    // 天气数据服务   :8678端口
│   ├── src/main
│   ├── ├──java/com/crossoverJie/hystrix/turbine
│   ├── ├──resources
├── report-service                  // 天气预报服务   :8670端口
│   ├── src/main
│   ├── ├──java/com/crossoverJie/sbcuser/
│   ├── ├──resources
├── .gitignore                                    // git忽略项             
├── README.md               
```

## 注册中心
![](https://github.com/27392/weather-cloud/blob/master/eureka.png)

### 项目分支

   - **master** 分支为微服务架构
   - **single** 分支为单块架构

### 技术栈
 
   - **微服务框架**  `springCloud`
   - **服务注册与发现** `eureka`
   - **缓存** `redis`
   - **服务消费**   `feign`
   - **网关** `zuul`
   - **配置中心**`springcloud-config`
   - **熔断**`hystrix`
   
    