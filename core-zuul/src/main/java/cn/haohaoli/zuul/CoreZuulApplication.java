package cn.haohaoli.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author liwenhao
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class CoreZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreZuulApplication.class, args);
    }
}
