package cn.haohaoli.weather.data.controller;

import cn.haohaoli.weather.data.service.WeatherDataService;
import cn.haohaoli.weather.data.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liwenhao
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse byCityName(@PathVariable String cityName){
        return weatherDataService.getDataByCityName(cityName);
    }

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse byCityId(@PathVariable String cityId){
        return weatherDataService.getDataByCityId(cityId);
    }
}
