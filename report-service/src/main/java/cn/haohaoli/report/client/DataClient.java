package cn.haohaoli.report.client;

import cn.haohaoli.report.vo.City;
import cn.haohaoli.report.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用网关
 * @author liwenhao
 * @sign 2018/9/28 10:52
 */
@FeignClient(value = "core-zuul",fallback = DataClient.DataFallback.class)
public interface DataClient {

    @GetMapping("/city/cities/list")
    List<City> listCity() throws Exception;

    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse byCityId(@PathVariable("cityId") String cityId);

    @Component
    class DataFallback implements DataClient {

        @Override
        public List<City> listCity() throws Exception {
            List<City> cityList = new ArrayList<>();
            cityList.add(new City("101040100","重庆","chongqing","重庆"));
            cityList.add(new City("101270101","成都","chengdu","四川"));
            cityList.add(new City("101240101","南昌","nanchang","江西"));
            return cityList;
        }

        @Override
        public WeatherResponse byCityId(String cityId) {
            return null;
        }
    }
}
