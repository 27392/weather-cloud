package cn.haohaoli.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author liwenhao
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class CoreConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreConfigApplication.class, args);
    }
}
