package cn.haohaoli.collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liwenhao
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CollectionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollectionServiceApplication.class, args);
    }
}
