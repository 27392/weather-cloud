package cn.haohaoli.report.report.client;

import cn.haohaoli.report.report.vo.City;
import cn.haohaoli.report.report.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 使用网关
 * @author liwenhao
 * @sign 2018/9/28 10:52
 */
@FeignClient("core-zuul")
public interface DataClient {

    @GetMapping("/city/cities/list")
    List<City> listCity() throws Exception;

    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse byCityId(@PathVariable("cityId") String cityId);
}
