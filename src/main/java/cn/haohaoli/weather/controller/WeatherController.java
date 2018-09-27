package cn.haohaoli.weather.controller;

import cn.haohaoli.weather.service.WeatherDataService;
import cn.haohaoli.weather.vo.WeatherResponse;
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
    public WeatherResponse byCityName(@PathVariable String cityName, @RequestParam(defaultValue = "false") boolean update){
        return weatherDataService.getDataByCityName(cityName, update);
    }

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse byCityId(@PathVariable String cityId){
        return weatherDataService.getDataByCityId(cityId,false);
    }
}
