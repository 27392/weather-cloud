package cn.haohaoli.report.report.client;

import cn.haohaoli.report.report.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liwenhao
 * @sign 2018/9/28 10:52
 */
@FeignClient("data-service")
public interface DataClient {

    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse byCityId(@PathVariable("cityId") String cityId);
}
