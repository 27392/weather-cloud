package cn.haohaoli.report.report.client;

import cn.haohaoli.report.report.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author liwenhao
 * @sign 2018/9/28 10:51
 */
@FeignClient("city-service")
public interface CityClient {

    @GetMapping("/cities/list")
    List<City> listCity() throws Exception;

}
