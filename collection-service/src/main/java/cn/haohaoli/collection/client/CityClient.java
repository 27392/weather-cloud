package cn.haohaoli.collection.client;

import cn.haohaoli.collection.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author liwenhao
 * @sign 2018/9/28 10:38
 */
@FeignClient("city-service")
public interface CityClient {

    @GetMapping("/cities/list")
    List<City> listCity() throws Exception;
}
