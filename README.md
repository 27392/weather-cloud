# weather-cloud
    
  ⛅基于Spring-Cloud技术栈实现的天气预报微服务项目
  
  该项目通过天气数据API为数据来源，Redis为数据存储。由SpringBoot单块架构进阶为SpringCloud微服务架构
  
  城市数据API接口：http://mobile.weather.com.cn/js/citylist.xml
  
  天气数据API接口：http://wthrcdn.etouch.cn/weather_mini?citykey=101040100 (例如重庆)
  
  
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
│   ├── ├──java/cn/haohaoli/config  
│   ├── ├──resources
│   ├── ├── ├── city.xml            城市数据xml文件
├── core-config-repo                // 统一配置文件
├── core-eureka                     // 注册中心       :8761端口
│   ├── src/main
│   ├── ├──java/cn/haohaoli/eureka
│   ├── ├──resources
├── core-zuul                       // 服务网关       :8765端口
│   ├── src/main
│   ├── ├──java/cn/haohaoli/zuul
│   ├── ├──resources
├── data-service                    // 天气数据服务   :8678端口
│   ├── src/main
│   ├── ├──java/cn/haohaoli/data
│   ├── ├──resources
├── report-service                  // 天气预报服务   :8670端口
│   ├── src/main
│   ├── ├──java/cn/haohaoli/report
│   ├── ├──resources
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
   
### 其他
  
  Redis有bug有时间看
  后期会加上用户服务。用户订阅天气发送邮件等功能。以及改造UI界面